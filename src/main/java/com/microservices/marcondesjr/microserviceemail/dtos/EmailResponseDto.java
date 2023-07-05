package com.microservices.marcondesjr.microserviceemail.dtos;

import com.microservices.marcondesjr.microserviceemail.domain.Email;
import com.microservices.marcondesjr.microserviceemail.enums.StatusEmail;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailResponseDto {

    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;


    public static EmailResponseDto toResponseDto (Email email){
        return EmailResponseDto.builder()
                .emailFrom(email.getEmailFrom())
                .emailTo(email.getEmailTo())
                .subject(email.getSubject())
                .text(email.getText())
                .sendDateEmail(email.getSendDateEmail())
                .statusEmail(email.getStatusEmail())
                .build();
    }
}
