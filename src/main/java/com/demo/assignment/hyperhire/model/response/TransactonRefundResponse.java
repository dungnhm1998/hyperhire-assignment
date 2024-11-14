package com.demo.assignment.hyperhire.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactonRefundResponse {
    String id;
    String reference;
    String amount;
    String requestAmount;
    String extraFee;
    String status;
}