package com.demo.assignment.hyperhire.model.request;

import lombok.Data;

@Data
public class ReservationRequest {
    String email;
    String name;
    String password;
}