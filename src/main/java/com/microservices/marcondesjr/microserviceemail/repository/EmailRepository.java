package com.microservices.marcondesjr.microserviceemail.repository;

import com.microservices.marcondesjr.microserviceemail.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
