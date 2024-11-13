package com.demo.assignment.hyperhire.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "MOCKUP")
@Data
public class Mockup {
    @Id
    private String id;
    private String url;
    private String type;
    @Column(name = "room_id")
    private Long roomId;
}
