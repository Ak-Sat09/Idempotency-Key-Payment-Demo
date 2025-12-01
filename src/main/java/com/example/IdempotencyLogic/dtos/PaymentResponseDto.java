package com.example.IdempotencyLogic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDto {
    private String paymentId;
    private String idempotencyKey;
    private String status; // SUCCESS / FAILED
    private String message; // human-readable message
    private double amount;
}
