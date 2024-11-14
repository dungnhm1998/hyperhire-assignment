package com.demo.assignment.hyperhire.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactonPaymentRequest {
    String id;
    Long token;
    String amount;
}