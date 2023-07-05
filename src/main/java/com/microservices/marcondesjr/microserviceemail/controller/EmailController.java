package com.microservices.marcondesjr.microserviceemail.controller;

import com.microservices.marcondesjr.microserviceemail.domain.Email;
import com.microservices.marcondesjr.microserviceemail.dtos.EmailRequestDto;
import com.microservices.marcondesjr.microserviceemail.dtos.EmailResponseDto;
import com.microservices.marcondesjr.microserviceemail.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailResponseDto> sendingEmail(@RequestBody @Valid EmailRequestDto emailDto){
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        EmailResponseDto emailResponseDto = emailService.sendEmail(email);
        return new ResponseEntity<>(emailResponseDto, HttpStatus.CREATED);
    }
}
