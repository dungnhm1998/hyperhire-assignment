package com.demo.assignment.hyperhire.model.dto;

import com.demo.assignment.hyperhire.model.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDto {
    private Long id;
    private Integer roomId;
    private String totalPrice;
    private Integer totalGuest;
    private String price;
    private String tax;
    private String discount;
    private String extraFee;
    private Integer guestChildren;
    private Integer guestInfants;
    private Integer guestPets;
    private Integer guestAdult;
    private String guestPhoto;
    private String guestPhone;
    private Date checkIn;
    private Date checkOut;
    private Date cancelAllowAt;
    private String status;
    private Date createAt;
    private Date updateAt;
    private Date payAt;
    private Date deleteAt;

    public static ReservationDto fromEntity(Reservation entity) {
        return ReservationDto.builder()
                .roomId(entity.getRoomId())
//                .totalPrice(entity.getTotalPrice())
//                .totalGuest(entity.getTotalGuest())
//                .price(entity.getPrice())
//                .tax(entity.getTax())
//                .discount(entity.getDiscount())
//                .extraFee(entity.getExtraFee())
                .guestChildren(entity.getGuestChildren())
                .guestInfants(entity.getGuestInfants())
                .guestPets(entity.getGuestPets())
                .guestAdult(entity.getGuestAdult())
                .guestPhoto(entity.getGuestPhoto())
                .guestPhone(entity.getGuestPhone())
                .checkIn(entity.getCheckIn())
                .checkOut(entity.getCheckOut())
                .cancelAllowAt(entity.getCancelAllowAt())
                .status(entity.getStatus())
                .createAt(new Date(entity.getCreateAt().getTime()))
                .updateAt(new Date(entity.getCreateAt().getTime()))
                .createAt(new Date(entity.getCreateAt().getTime()))
                .updateAt(new Date(entity.getUpdateAt().getTime()))
                .payAt(new Date(entity.getPayAt().getTime()))
                .deleteAt(new Date(entity.getDeleteAt().getTime()))
                .build();
    }

}