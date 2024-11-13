package com.demo.assignment.hyperhire.service.impl;

import com.demo.assignment.hyperhire.model.dto.ReservationDto;
import com.demo.assignment.hyperhire.model.entity.Reservation;
import com.demo.assignment.hyperhire.model.request.ReservationRequest;
import com.demo.assignment.hyperhire.repository.ReservationRepository;
import com.demo.assignment.hyperhire.service.ReservationService;
import com.demo.assignment.hyperhire.util.StatePool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public ReservationDto createReservation(ReservationRequest request) {

        Reservation reservation = new Reservation();

        ReservationDto reservationDto = ReservationDto.fromEntity(reservation);

        return reservationDto;
    }

    @Override
    public ReservationDto getReservation(Long id) {
        //todo
        return null;
    }

    @Override
    public ReservationDto updateReservation(Long id, ReservationRequest request) {
        //todo
        return null;
    }

    @Override
    public ReservationDto calculateReservation(ReservationRequest request) {
        //todo
        return null;
    }

    @Override
    public ReservationDto cancelReservation(Long id) {
        //todo
        return null;
    }

}
