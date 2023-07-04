package com.microservices.marcondesjr.microserviceemail.repository;

import com.microservices.marcondesjr.microserviceemail.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}
