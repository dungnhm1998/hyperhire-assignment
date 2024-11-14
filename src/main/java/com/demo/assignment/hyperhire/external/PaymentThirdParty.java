package com.demo.assignment.hyperhire.external;

import com.demo.assignment.hyperhire.model.entity.Payment;
import com.demo.assignment.hyperhire.model.entity.Reservation;
import com.demo.assignment.hyperhire.model.request.TransactonPaymentRequest;
import com.demo.assignment.hyperhire.model.request.TransactonRefundRequest;
import com.demo.assignment.hyperhire.model.response.TransactonPaymentResponse;
import com.demo.assignment.hyperhire.model.response.TransactonRefundResponse;
import com.demo.assignment.hyperhire.util.CommonUtil;
import com.demo.assignment.hyperhire.util.StatePool;

public class PaymentThirdParty {

    public static TransactonPaymentRequest createRequest(Reservation reservation) {
        return TransactonPaymentRequest.builder()
                .id(CommonUtil.generateUUIDString())
                .token(reservation.getId())
                .amount(reservation.getTotalPrice())
                .build();
    }

    public static TransactonRefundRequest createRefundRequest(Payment payment) {
        return TransactonRefundRequest.builder()
                .id(payment.getTransactionId())
                .reference(payment.getId())
                .amount(payment.getTotalAmount())
                .build();
    }

    public static TransactonPaymentResponse doPayment(TransactonPaymentRequest paymentRequest) {
        Double amountRequest = Double.valueOf(paymentRequest.getAmount());
        Double extraFee = 0.2 + amountRequest / 100 * 1;
        Double total = amountRequest + extraFee;

        TransactonPaymentResponse response = TransactonPaymentResponse.builder()
                .id(CommonUtil.generateUUIDString())
                .token(paymentRequest.getToken())
                .reference(paymentRequest.getId())
                .totalAmount(String.valueOf(total))
                .requestAmount(String.valueOf(amountRequest))
                .extraFee(String.valueOf(extraFee))
                .build();
        if (paymentRequest.getToken() % 2 == 0) {
            response.setStatus(StatePool.APPROVED.getCode());
        } else {
            response.setStatus(StatePool.FAILED.getCode());
        }

        return response;
    }

    public static TransactonRefundResponse doRefund(TransactonRefundRequest exampleRequest) {

        return TransactonRefundResponse.builder()
                .id(CommonUtil.generateUUIDString())
                .reference(exampleRequest.getReference())
                .amount(String.valueOf(exampleRequest.getAmount()))
                .status(StatePool.APPROVED.getCode())
                .build();
    }
}
