package com.demo.assignment.hyperhire.controller;

import com.demo.assignment.hyperhire.model.dto.PaymentDto;
import com.demo.assignment.hyperhire.model.dto.PaymentMethodDto;
import com.demo.assignment.hyperhire.model.request.PaymentRequest;
import com.demo.assignment.hyperhire.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/methods")
    public List<PaymentMethodDto> getPaymentMethods() {
        return paymentService.getPaymentMethods();
    }

    @PostMapping
    public PaymentDto createPayment(PaymentRequest request) {
        return paymentService.createPayment(request);
    }

    @PatchMapping("/{id}/refund")
    public PaymentDto updatePayment(@PathVariable(name = "id") String transactionId) {
        return paymentService.refundPayment(transactionId);
    }

    @PostMapping("/notify")
    public PaymentDto updatePayment(@PathVariable(name = "id") Long id,
                                    PaymentRequest request) {
        return paymentService.updatePayment(id, request);
    }

}