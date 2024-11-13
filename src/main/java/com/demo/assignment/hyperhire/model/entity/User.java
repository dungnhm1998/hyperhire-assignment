package com.demo.assignment.hyperhire.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USER_PROFILE")
@Data
public class User {
    @Id
    private Long id;
    private String email;
    private String name;
    private String password;
}
