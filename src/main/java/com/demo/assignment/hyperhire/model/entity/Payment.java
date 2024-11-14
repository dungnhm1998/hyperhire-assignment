package com.demo.assignment.hyperhire.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "PAYMENT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private String id;
    @Column(name = "reservation_id")
    private Long reservationId;
    @Column(name = "total_amount")
    private String totalAmount;
    @Column(name = "extra_fee")
    private String extraFee;
    @Column(name = "transaction_id")
    private String transactionId;
    private String token;
    private String method;
    private String status;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "delete_at")
    private Date deleteAt;
}
