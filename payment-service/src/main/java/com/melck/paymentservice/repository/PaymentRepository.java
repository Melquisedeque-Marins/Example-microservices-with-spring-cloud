package com.melck.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melck.paymentservice.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
