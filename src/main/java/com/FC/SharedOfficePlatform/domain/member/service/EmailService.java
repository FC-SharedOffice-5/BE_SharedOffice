package com.FC.SharedOfficePlatform.domain.member.service;

import com.FC.SharedOfficePlatform.domain.member.entity.VerificationCode;
import com.FC.SharedOfficePlatform.domain.member.repository.VerificationCodeRepository;
import com.FC.SharedOfficePlatform.domain.member.exception.EmailSendingException;
import com.FC.SharedOfficePlatform.domain.member.exception.InvalidVerificationCodeException;
import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final VerificationCodeRepository verificationCodeRepository;

    @Value("${SENDER_EMAIL}")
    private String senderEmail;

    public void sendVerificationCode(String toEmail) {
        String verificationCode = generateVerificationCode();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Email Verification Code");
        message.setText("Your verification code is!: " + verificationCode);
        message.setFrom(senderEmail);

        try {
            javaMailSender.send(message);
            VerificationCode code = new VerificationCode(toEmail, verificationCode);
            verificationCodeRepository.save(code);
        } catch (MailException e) {
            throw new EmailSendingException();
        }
    }

    public boolean verifyCode(String email, String code) {
        Optional<VerificationCode> storedCode = verificationCodeRepository.findByEmailAndCode(email, code);
        if (storedCode.isPresent()) {
            verificationCodeRepository.deleteByEmail(email); // Remove the code after successful verification
            return true;
        }
        throw new InvalidVerificationCodeException();
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
