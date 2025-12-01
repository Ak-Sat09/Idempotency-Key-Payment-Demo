package com.example.IdempotencyLogic.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.IdempotencyLogic.dtos.PaymentResponseDto;
import com.example.IdempotencyLogic.entities.IdempotencyRecord;
import com.example.IdempotencyLogic.entities.Payment;
import com.example.IdempotencyLogic.repositories.IdempotencyRepo;
import com.example.IdempotencyLogic.repositories.PaymentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final IdempotencyRepo idempotencyRepo;
    private final PaymentRepo paymentRepo;

    public PaymentResponseDto pay(String userId, String key, double amount) {

        Optional<IdempotencyRecord> existing = idempotencyRepo.findById(key);
        if (existing.isPresent()) {
            IdempotencyRecord rec = existing.get();
            return new PaymentResponseDto(
                    String.valueOf(rec.getPaymentId()),
                    rec.getIdempotencyKey(),
                    "SUCCESS",
                    "Payment already processed",
                    amount);
        }

        // Create new payment
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setAmount(amount);
        payment.setStatus("SUCCESS");
        paymentRepo.save(payment);

        // Save idempotency record
        IdempotencyRecord rec = new IdempotencyRecord();
        rec.setIdempotencyKey(key);
        rec.setPaymentId(payment.getId());
        rec.setUserId(userId);
        rec.setResponseJson("Payment processed successfully");
        idempotencyRepo.save(rec);

        // Return DTO
        return new PaymentResponseDto(
                String.valueOf(payment.getId()),
                key,
                "SUCCESS",
                "Payment processed successfully",
                amount);
    }

}
