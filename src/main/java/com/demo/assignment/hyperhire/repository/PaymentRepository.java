package com.demo.assignment.hyperhire.repository;

import com.demo.assignment.hyperhire.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}
