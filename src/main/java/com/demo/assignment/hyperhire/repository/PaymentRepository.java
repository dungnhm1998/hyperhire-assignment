package com.demo.assignment.hyperhire.repository;

import com.demo.assignment.hyperhire.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    Optional<Payment> findByReservationId(Long id);
    Optional<Payment> findByTransactionId(String id);
}
