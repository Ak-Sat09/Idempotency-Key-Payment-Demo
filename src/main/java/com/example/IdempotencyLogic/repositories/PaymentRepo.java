package com.example.IdempotencyLogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IdempotencyLogic.entities.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
