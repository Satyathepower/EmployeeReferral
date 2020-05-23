package com.hk.EmployeeReferral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailServiceImpl implements  EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public String sendMailToCandidate() throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("satendra.kumar@brightlifecare.com");
        helper.setText("How are you?");
        helper.setSubject("Hi");

        javaMailSender.send(message);
        return null;
    }
}
