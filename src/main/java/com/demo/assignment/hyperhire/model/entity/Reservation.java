package com.demo.assignment.hyperhire.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "RESERVATION")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVATION_SEQ")
    @SequenceGenerator(name = "RESERVATION_SEQ", sequenceName = "RESERVATION_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "total_price")
    private String totalPrice;
    @Column(name = "total_guest")
    private Integer totalGuest;
    private String price;
    private String tax;
    private String discount;
    @Column(name = "extra_fee")
    private String extraFee;
    @Column(name = "guest_children")
    private Integer guestChildren;
    @Column(name = "guest_infants")
    private Integer guestInfants;
    @Column(name = "guest_pets")
    private Integer guestPets;
    @Column(name = "guest_adult")
    private Integer guestAdult;
    @Column(name = "guest_photo")
    private String guestPhoto;
    @Column(name = "guest_phone")
    private String guestPhone;
    @Column(name = "check_in")
    private Date checkIn;
    @Column(name = "check_out")
    private Date checkOut;
    @Column(name = "cancel_allow_at")
    private Date cancelAllowAt;
    private String status;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "pay_at")
    private Date payAt;
    @Column(name = "delete_at")
    private Date deleteAt;
}
