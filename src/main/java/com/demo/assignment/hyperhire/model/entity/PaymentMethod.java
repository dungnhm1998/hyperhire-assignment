package com.demo.assignment.hyperhire.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "PAYMENT_METHOD")
@Data
public class PaymentMethod {
    @Id
    private String id;
    private String method;
    private String name;
    private String status;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "delete_at")
    private Date deleteAt;
}
