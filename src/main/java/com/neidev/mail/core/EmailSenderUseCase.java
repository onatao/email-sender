package com.neidev.mail.core;

/* represents application business rules */
public interface EmailSenderUseCase {
    void sendEmail(String to, String subject, String body);
}
