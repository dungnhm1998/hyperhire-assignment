package com.demo.assignment.hyperhire.service.impl;

import com.demo.assignment.hyperhire.model.dto.ReservationDto;
import com.demo.assignment.hyperhire.model.entity.Payment;
import com.demo.assignment.hyperhire.model.entity.Reservation;
import com.demo.assignment.hyperhire.model.entity.Room;
import com.demo.assignment.hyperhire.model.exception.BadRequestException;
import com.demo.assignment.hyperhire.model.exception.ServerError;
import com.demo.assignment.hyperhire.model.request.ReservationRequest;
import com.demo.assignment.hyperhire.repository.PaymentRepository;
import com.demo.assignment.hyperhire.repository.ReservationRepository;
import com.demo.assignment.hyperhire.repository.RoomRepository;
import com.demo.assignment.hyperhire.service.ReservationService;
import com.demo.assignment.hyperhire.util.ActionPool;
import com.demo.assignment.hyperhire.util.DateTimeUtil;
import com.demo.assignment.hyperhire.util.StatePool;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ReservationDto createReservation(ReservationRequest request) {

        ReservationDto reservationDto = calculateReservation(request);

        reservationDto.setStatus(StatePool.CREATED.getCode());
        reservationDto.setCreateAt(new Date());

        Reservation reservation = Reservation.fromDto(reservationDto);
        reservation = reservationRepository.save(reservation);
        reservationDto.setId(reservation.getId());

        return reservationDto;
    }

    @Override
    public ReservationDto getReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_RESERVATION));
        return ReservationDto.fromEntity(reservation);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ReservationDto updateReservation(Long id, ReservationRequest request) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_RESERVATION));

        ReservationDto reservationDto = calculateReservation(request);
        reservationDto.setId(id);

        reservation.setTotalGuest(reservationDto.getTotalGuest());
        reservation.setTotalPrice(reservationDto.getTotalPrice());
        reservation.setPrice(reservationDto.getPrice());
        reservation.setCheckInAt(reservationDto.getCheckInAt());
        reservation.setCheckOutAt(reservationDto.getCheckOutAt());
        reservation.setCancelAllowAt(reservationDto.getCancelAllowAt());
        reservation.setGuestAdult(reservationDto.getGuestAdult());
        reservation.setGuestChildren(reservationDto.getGuestChildren());
        reservation.setGuestInfants(reservationDto.getGuestInfants());
        reservation.setGuestPets(reservationDto.getGuestPets());
        reservation.setUpdateAt(new Date());
        reservationRepository.save(reservation);

        return reservationDto;
    }

    @Override
    public ReservationDto calculateReservation(ReservationRequest request) {

        Room room = roomRepository.findById(request.getRoomId()).orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_ROOM));

        Double roomPrice = Double.valueOf(room.getPrice());
        long days = DateTimeUtil.getDaysDifference(request.getCheckInAt(), request.getCheckOutAt());

        Double totalPrice = roomPrice * days;
        Integer totalGuest = request.getGuestAdult() + request.getGuestChildren() + request.getGuestInfants() + request.getGuestPets();
        Date cancelAllowAt = DateTimeUtil.addDays(request.getCheckOutAt(), 1);

        return ReservationDto.builder()
                .roomId(request.getRoomId())
                .checkInAt(DateTimeUtil.convertStringToDate(request.getCheckInAt()))
                .checkOutAt(DateTimeUtil.convertStringToDate(request.getCheckOutAt()))
                .guestAdult(request.getGuestAdult())
                .guestChildren(request.getGuestChildren())
                .guestInfants(request.getGuestInfants())
                .guestPets(request.getGuestPets())
                .totalPrice(String.valueOf(totalPrice))
                .price(String.valueOf(roomPrice))
                .totalGuest(totalGuest)
                .cancelAllowAt(cancelAllowAt)
                .build();

    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ReservationDto cancelReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_RESERVATION));

        Date cancelAllowAt = reservation.getCancelAllowAt();
        if (new Date().after(cancelAllowAt)) {
            throw new BadRequestException(ServerError.OVERDUE_ALLOWED_CANCEL_DATE);
        }

        reservation.setStatus(StatePool.CANCELLED.getCode());
        reservation.setUpdateAt(new Date());
        reservationRepository.save(reservation);

        return ReservationDto.fromEntity(reservation);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ReservationDto confirmOrDenyReservation(Long id, String action) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_RESERVATION));
        String status = reservation.getStatus();
        Payment payment = paymentRepository.findByReservationId(id).orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_PAYMENT));

        if (action.equals(ActionPool.APPROVE.getCode())) {
            if (payment.getStatus().equals(StatePool.APPROVED.getCode())
                    && reservation.getStatus().equals(StatePool.PENDING.getCode())) {
                status = StatePool.APPROVED.getCode();
            } else {
                throw new BadRequestException(ServerError.CANNOT_DO_ACTION_ON_RESERVATION);
            }
        } else if (action.equals(ActionPool.DENY.getCode())) {
            if (payment.getStatus().equals(StatePool.APPROVED.getCode())
                    && reservation.getStatus().equals(StatePool.PENDING.getCode())) {
                status = StatePool.CANCELLED.getCode();
            } else {
                throw new BadRequestException(ServerError.CANNOT_DO_ACTION_ON_RESERVATION);
            }
        } else {
            throw new BadRequestException(ServerError.INVALID_ACTION);
        }

        reservation.setStatus(status);
        reservation.setUpdateAt(new Date());
        reservationRepository.save(reservation);
        return ReservationDto.fromEntity(reservation);
    }

}
