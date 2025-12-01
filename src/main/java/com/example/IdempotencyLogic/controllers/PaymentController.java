package com.example.IdempotencyLogic.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.IdempotencyLogic.dtos.PaymentRequestDto;
import com.example.IdempotencyLogic.dtos.PaymentResponseDto;
import com.example.IdempotencyLogic.services.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/api/pay")
    public PaymentResponseDto pay(
            @RequestHeader("Idempotency-Key") String key,
            @RequestHeader("User-Id") String userId,
            @RequestBody PaymentRequestDto request) {

        return paymentService.pay(userId, key, request.getAmount());
    }
}
