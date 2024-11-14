package com.demo.assignment.hyperhire.repository;

import com.demo.assignment.hyperhire.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
