package com.FC.SharedOfficePlatform.domain.member.service;

import java.security.SecureRandom;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${SENDER_EMAIL}")
    private String senderEmail;

    public void sendVerificationCode(String toEmail) {
        String verificationCode = generateVerificationCode();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("이메일 인증 번호");
        message.setText("your verification code : " + verificationCode); // printed on the console
        message.setFrom(senderEmail);

        javaMailSender.send(message);
    }

    private String generateVerificationCode() {
        int codeLength = 6;
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder(codeLength);
        for (int i = 0; i < codeLength; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}

