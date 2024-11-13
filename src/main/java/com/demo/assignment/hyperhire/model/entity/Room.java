package com.demo.assignment.hyperhire.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "ROOM")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_SEQ")
    @SequenceGenerator(name = "ROOM_SEQ", sequenceName = "ROOM_SEQ", allocationSize = 1)
    private Long id;
    private String name;
    private String state;
    private String country;
    @Column(name = "interior_bed")
    private Integer interiorBed;
    @Column(name = "interior_room")
    private Integer interiorRoom;
    @Column(name = "interior_bathroom")
    private Integer interiorBathroom;
    @Column(name = "point")
    private String point;
    @Column(name = "price")
    private String price;
    private String currency;
    @Column(name = "owner")
    private String owner;
    @Column(name = "short_desc")
    private String shortDesc;
    @Lob
    @Column(name = "long_desc")
    private String longDesc;
    private String rule;
    private String category_id;
    private String type;
    private String status;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "delete_at")
    private Date deleteAt;
}
