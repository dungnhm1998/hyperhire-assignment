package com.demo.assignment.hyperhire.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationRequest {
//    @JsonProperty(value = "room_id")
    private Long roomId;
//    @JsonProperty(value = "check_in_at")
    private String checkInAt;
//    @JsonProperty(value = "check_out_at")
    private String checkOutAt;

//    @JsonProperty(value = "guest_adult")
    private Integer guestAdult;
//    @JsonProperty(value = "guest_children")
    private Integer guestChildren;
//    @JsonProperty(value = "guest_infants")
    private Integer guestInfants;
//    @JsonProperty(value = "guest_pets")
    private Integer guestPets;
}
