package com.demo.assignment.hyperhire.repository;

import com.demo.assignment.hyperhire.model.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, String> {

}
