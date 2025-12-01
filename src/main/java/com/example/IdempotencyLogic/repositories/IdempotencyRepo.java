package com.example.IdempotencyLogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.IdempotencyLogic.entities.IdempotencyRecord;

public interface IdempotencyRepo extends JpaRepository<IdempotencyRecord, String> {

}
