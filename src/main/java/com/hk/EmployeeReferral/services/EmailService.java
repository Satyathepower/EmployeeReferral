package com.hk.EmployeeReferral.services;

import javax.mail.MessagingException;

public interface EmailService {
    public String sendMailToCandidate() throws MessagingException;
}
