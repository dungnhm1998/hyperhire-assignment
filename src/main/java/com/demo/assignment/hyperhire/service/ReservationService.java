package com.demo.assignment.hyperhire.service;

import com.demo.assignment.hyperhire.model.dto.ReservationDto;
import com.demo.assignment.hyperhire.model.request.ReservationRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReservationService {

    public ReservationDto createReservation(ReservationRequest request);

    public ReservationDto getReservation(Long id);

    public ReservationDto updateReservation(Long id, ReservationRequest request);

    public ReservationDto calculateReservation(ReservationRequest request);

    public ReservationDto cancelReservation(Long id);
}
