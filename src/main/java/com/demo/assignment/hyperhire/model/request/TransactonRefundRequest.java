package com.demo.assignment.hyperhire.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactonRefundRequest {
    String id;
    String reference;
    String amount;
}