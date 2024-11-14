package com.demo.assignment.hyperhire.service.impl;

import com.demo.assignment.hyperhire.external.PaymentThirdParty;
import com.demo.assignment.hyperhire.model.dto.PaymentDto;
import com.demo.assignment.hyperhire.model.dto.PaymentMethodDto;
import com.demo.assignment.hyperhire.model.entity.Payment;
import com.demo.assignment.hyperhire.model.entity.PaymentMethod;
import com.demo.assignment.hyperhire.model.entity.Reservation;
import com.demo.assignment.hyperhire.model.exception.BadRequestException;
import com.demo.assignment.hyperhire.model.exception.ServerError;
import com.demo.assignment.hyperhire.model.request.PaymentRequest;
import com.demo.assignment.hyperhire.model.request.TransactonPaymentRequest;
import com.demo.assignment.hyperhire.model.request.TransactonRefundRequest;
import com.demo.assignment.hyperhire.model.response.TransactonPaymentResponse;
import com.demo.assignment.hyperhire.model.response.TransactonRefundResponse;
import com.demo.assignment.hyperhire.repository.PaymentMethodRepository;
import com.demo.assignment.hyperhire.repository.PaymentRepository;
import com.demo.assignment.hyperhire.repository.ReservationRepository;
import com.demo.assignment.hyperhire.service.PaymentService;
import com.demo.assignment.hyperhire.util.StatePool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final ReservationRepository reservationRepository;


    @Override
    public List<PaymentMethodDto> getPaymentMethods() {
        List<PaymentMethod> methods = paymentMethodRepository.findAll();
        return PaymentMethodDto.fromEntities(methods);
    }

    @Override
    public PaymentDto createPayment(PaymentRequest request) {
        Reservation reservation = reservationRepository.findById(request.getReservationId()).orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_RESERVATION));

        log.info("reservation status = " + reservation.getStatus());
        if (!reservation.getStatus().equals(StatePool.CREATED.getCode())) {
            throw new BadRequestException(ServerError.CANNOT_DO_ACTION_ON_RESERVATION);
        }

        TransactonPaymentRequest exampleRequest = PaymentThirdParty.createRequest(reservation);
        TransactonPaymentResponse exampleResponse = PaymentThirdParty.doPayment(exampleRequest);
        Payment payment = Payment.builder()
                .id(exampleRequest.getId())
                .reservationId(reservation.getId())
                .totalAmount(reservation.getTotalPrice())
                .method(request.getMethod())
                .status(exampleResponse.getStatus())
                .createAt(new Date())
                .build();

        if (exampleResponse.getStatus().equals(StatePool.APPROVED.getCode())) {
            reservation.setPayAt(new Date());
            reservation.setUpdateAt(new Date());
            if (reservation.isConfirmed()) {
                reservation.setStatus(StatePool.APPROVED.getCode());
            } else {
                reservation.setStatus(StatePool.PENDING.getCode());
            }
        } else {
            throw new BadRequestException(ServerError.PAYMENT_PROCESSING_ERROR);
        }

        reservationRepository.save(reservation);
        paymentRepository.save(payment);

        return PaymentDto.fromEntity(payment);
    }

    @Override
    public PaymentDto refundPayment(String transactionId) {

        Payment payment = paymentRepository.findByTransactionId(transactionId).orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_PAYMENT));

        if (!payment.getStatus().equals(StatePool.APPROVED.getCode())) {
            throw new BadRequestException(ServerError.CANNOT_REFUND_PAYMENT);
        }

        TransactonRefundRequest exampleRequest = PaymentThirdParty.createRefundRequest(payment);
        TransactonRefundResponse exampleResponse = PaymentThirdParty.doRefund(exampleRequest);
        if (exampleResponse.getStatus().equals(StatePool.APPROVED.getCode())) {
            payment.setStatus(StatePool.REFUNDED.getCode());
            payment.setUpdateAt(new Date());

            Reservation reservation = reservationRepository.findById(payment.getReservationId()).orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_RESERVATION));
            reservation.setStatus(StatePool.REFUNDED.getCode());
            reservation.setUpdateAt(new Date());
        } else {
            throw new BadRequestException(ServerError.PAYMENT_REFUND_PROCESSING_ERROR);
        }

        paymentRepository.save(payment);

        return PaymentDto.fromEntity(payment);
    }

    @Override
    public PaymentDto updatePayment(Long id, PaymentRequest request) {
        //todo
        return null;
    }
}
