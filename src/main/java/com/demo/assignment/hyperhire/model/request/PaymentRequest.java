package com.demo.assignment.hyperhire.model.request;

import lombok.Data;

@Data
public class PaymentRequest {
    Long reservationId;
    String method;
}
