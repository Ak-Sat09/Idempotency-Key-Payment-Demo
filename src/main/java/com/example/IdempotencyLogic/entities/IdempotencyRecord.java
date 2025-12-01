package com.example.IdempotencyLogic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdempotencyRecord {

    @Id
    private String idempotencyKey;

    private Long paymentId;
    private String responseJson;
    private String userId;
}
