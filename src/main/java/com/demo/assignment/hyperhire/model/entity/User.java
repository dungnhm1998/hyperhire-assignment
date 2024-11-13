package com.demo.assignment.hyperhire.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USER_PROFILE")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", allocationSize = 1)
    private Long id;
    private String email;
    private String name;
    private String password;
}
