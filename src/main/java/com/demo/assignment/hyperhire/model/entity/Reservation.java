package com.demo.assignment.hyperhire.model.entity;

import com.demo.assignment.hyperhire.model.dto.ReservationDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "RESERVATION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVATION_SEQ")
    @SequenceGenerator(name = "RESERVATION_SEQ", sequenceName = "RESERVATION_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "room_id")
    private Long roomId;
    @Column(name = "total_price")
    private String totalPrice;
    @Column(name = "total_guest")
    private Integer totalGuest;
    private String price;
    private String tax;
    private String discount;
    @Column(name = "is_confirmed")
    private Integer isConfirmed;
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
    private Date checkInAt;
    @Column(name = "check_out")
    private Date checkOutAt;
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

    public static Reservation fromDto(ReservationDto reservationDto) {

        return Reservation.builder()
                .roomId(reservationDto.getRoomId())
                .totalPrice(reservationDto.getTotalPrice())
                .totalGuest(reservationDto.getTotalGuest())
                .price(reservationDto.getPrice())
                .guestAdult(reservationDto.getGuestAdult())
                .guestChildren(reservationDto.getGuestChildren())
                .guestInfants(reservationDto.getGuestInfants())
                .guestPets(reservationDto.getGuestPets())
                .checkInAt(reservationDto.getCheckInAt())
                .checkOutAt(reservationDto.getCheckOutAt())
                .cancelAllowAt(reservationDto.getCancelAllowAt())
                .status(reservationDto.getStatus())
                .createAt(reservationDto.getCreateAt())
                .build();
    }

    public boolean isConfirmed() {
        return this.isConfirmed != null && 1 == this.isConfirmed;
    }
}
