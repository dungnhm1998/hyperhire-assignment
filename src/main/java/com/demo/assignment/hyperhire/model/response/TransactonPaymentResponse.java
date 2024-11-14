package com.demo.assignment.hyperhire.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactonPaymentResponse {
    String id;
    Long token;
    String reference;
    String totalAmount;
    String requestAmount;
    String extraFee;
    String status;
}