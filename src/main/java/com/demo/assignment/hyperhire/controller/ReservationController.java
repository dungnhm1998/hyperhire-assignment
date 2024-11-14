package com.demo.assignment.hyperhire.controller;

import com.demo.assignment.hyperhire.model.dto.ReservationDto;
import com.demo.assignment.hyperhire.model.request.ReservationRequest;
import com.demo.assignment.hyperhire.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    @PostMapping("/calculate")
    public ReservationDto calculateReservation(ReservationRequest request) {
        return reservationService.calculateReservation(request);
    }

    private final ReservationService reservationService;

    @PostMapping
    public ReservationDto createReservation(ReservationRequest request) {
        return reservationService.createReservation(request);
    }

    @GetMapping("/{id}")
    public ReservationDto getReservation(@PathVariable(name = "id") Long id) {
        return reservationService.getReservation(id);
    }

    @PutMapping("/{id}")
    public ReservationDto updateReservation(@PathVariable(name = "id") Long id,
                                            ReservationRequest request) {
        return reservationService.updateReservation(id, request);
    }

    @PatchMapping("/{id}/cancel")
    public ReservationDto updateReservation(@PathVariable(name = "id") Long id) {
        return reservationService.cancelReservation(id);
    }

    @PatchMapping("/{id}/{action}")
    public ReservationDto confirmReservation(@PathVariable(name = "id") Long id, @PathVariable(name = "action") String action) {
        return reservationService.confirmOrDenyReservation(id, action);
    }
}