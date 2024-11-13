package com.demo.assignment.hyperhire.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "CATEGORY")
@Data
public class Category {
    @Id
    private String id;
    private String name;
    private String status;
    private int position;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "delete_at")
    private Date deleteAt;
}
