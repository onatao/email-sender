package com.neidev.mail.core.record;

public record EmailRequest(
        String to,
        String subject,
        String body) {
}
