package com.microservices.marcondesjr.microserviceemail.consumers;

import com.microservices.marcondesjr.microserviceemail.domain.Email;
import com.microservices.marcondesjr.microserviceemail.dtos.EmailRequestDto;
import com.microservices.marcondesjr.microserviceemail.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen (@Payload EmailRequestDto emailDto){
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        emailService.sendEmail(email);
        System.out.println("Email Status: " + email.getStatusEmail().toString());
    }
}
