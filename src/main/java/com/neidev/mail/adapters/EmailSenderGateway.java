package com.neidev.mail.adapters;

/**
 *  adapt amazon ses service for the application needs,
 *  the application doesn't depend on amazon service directly,
 *  it depends on this adapter interface.
 */
public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);
}
