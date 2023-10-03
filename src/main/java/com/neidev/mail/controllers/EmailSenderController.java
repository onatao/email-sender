package com.neidev.mail.controllers;

import com.neidev.mail.application.EmailSenderService;
import com.neidev.mail.core.record.EmailRequest;
import com.neidev.mail.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest data) {
        try {
            emailSenderService.sendEmail(data.to(), data.subject(), data.body());
            return ResponseEntity.ok("Email sent successfully");
        } catch (EmailServiceException e) {
            return ResponseEntity.status
                    (HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email");
        }
    }
}
