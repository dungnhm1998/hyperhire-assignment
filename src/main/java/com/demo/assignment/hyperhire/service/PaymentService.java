package com.demo.assignment.hyperhire.service;

import com.demo.assignment.hyperhire.model.dto.PaymentDto;
import com.demo.assignment.hyperhire.model.dto.PaymentMethodDto;
import com.demo.assignment.hyperhire.model.request.PaymentRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface PaymentService {

    public List<PaymentMethodDto> getPaymentMethod();

    public PaymentDto createPayment(PaymentRequest request);

    public PaymentDto confirmPayment(Long id);

    public PaymentDto refundPayment(Long id);

    public PaymentDto updatePayment(Long id, PaymentRequest request);
}
