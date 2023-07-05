package com.microservices.marcondesjr.microserviceemail.service;

import com.microservices.marcondesjr.microserviceemail.domain.Email;
import com.microservices.marcondesjr.microserviceemail.dtos.EmailResponseDto;
import com.microservices.marcondesjr.microserviceemail.enums.StatusEmail;
import com.microservices.marcondesjr.microserviceemail.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;


    public EmailResponseDto sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setText(email.getText());
            message.setSubject(email.getSubject());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);

        }catch (MailException ex){
            email.setStatusEmail(StatusEmail.ERROR);
            ex.getMessage();

        }finally {
            emailRepository.save(email);
            return EmailResponseDto.toResponseDto(email);
        }
    }
}
