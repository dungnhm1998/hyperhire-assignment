package com.demo.assignment.hyperhire.model.dto;

import com.demo.assignment.hyperhire.model.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {

    private String id;
    private Long reservationId;
    private String totalAmount;
    private String extraFee;
    private String transactionId;
    private String token;
    private String method;
    private String status;
    private Date createAt;
    private Date updateAt;
    private Date deleteAt;

    public static PaymentDto fromEntity(Payment entity) {
        return PaymentDto.builder()
                .id(entity.getId())
                .reservationId(entity.getReservationId())
                .totalAmount(entity.getTotalAmount())
                .extraFee(entity.getExtraFee())
                .method(entity.getMethod())
                .transactionId(entity.getTransactionId())
                .token(entity.getToken())
                .status(entity.getStatus())
                .createAt(new Date(entity.getCreateAt().getTime()))
                .build();
    }
}
