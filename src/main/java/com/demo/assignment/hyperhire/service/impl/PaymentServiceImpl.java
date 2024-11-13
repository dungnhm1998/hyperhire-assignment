package com.demo.assignment.hyperhire.service.impl;

import com.demo.assignment.hyperhire.model.dto.PaymentDto;
import com.demo.assignment.hyperhire.model.dto.PaymentMethodDto;
import com.demo.assignment.hyperhire.model.entity.Payment;
import com.demo.assignment.hyperhire.model.request.PaymentRequest;
import com.demo.assignment.hyperhire.repository.PaymentMethodRepository;
import com.demo.assignment.hyperhire.repository.PaymentRepository;
import com.demo.assignment.hyperhire.service.PaymentService;
import com.demo.assignment.hyperhire.util.StatePool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMethodRepository paymentMethodRepository;


    @Override
    public List<PaymentMethodDto> getPaymentMethod() {
        //todo
        return List.of();
    }

    @Override
    public PaymentDto createPayment(PaymentRequest request) {
        //todo
        return null;
    }

    @Override
    public PaymentDto confirmPayment(Long id) {
        //todo
        return null;
    }

    @Override
    public PaymentDto refundPayment(Long id) {
        //todo
        return null;
    }

    @Override
    public PaymentDto updatePayment(Long id, PaymentRequest request) {
        //todo
        return null;
    }
}
