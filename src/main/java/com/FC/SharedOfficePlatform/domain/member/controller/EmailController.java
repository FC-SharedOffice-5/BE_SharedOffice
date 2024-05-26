package com.FC.SharedOfficePlatform.domain.member.controller;

import com.FC.SharedOfficePlatform.domain.member.dto.request.SendEmailRequest;
import com.FC.SharedOfficePlatform.domain.member.service.EmailService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send/code")
    public ResponseEntity<ResponseDTO<Void>> sendVerificationCode(
        @RequestBody SendEmailRequest request) {
        emailService.sendVerificationCode(request.email());
        return ResponseEntity.ok(ResponseDTO.ok());
    }
}

