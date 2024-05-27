package com.FC.SharedOfficePlatform.domain.member.controller;

import com.FC.SharedOfficePlatform.domain.member.dto.request.SearchEmailRequest;
import com.FC.SharedOfficePlatform.domain.member.dto.request.SendEmailRequest;
import com.FC.SharedOfficePlatform.domain.member.dto.response.SearchEmailResponse;
import com.FC.SharedOfficePlatform.domain.member.service.EmailService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/verify/{code}")
    public ResponseEntity<ResponseDTO<Void>> verifyEmail(@PathVariable String code, @RequestParam String email) {
        emailService.verifyCode(email, code);
        return ResponseEntity.ok(ResponseDTO.ok());
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO<SearchEmailResponse>> searchEmail(
        @Valid @RequestBody SearchEmailRequest request
    ) {
        SearchEmailResponse response = emailService.searchEmail(request);
        return ResponseEntity.ok(ResponseDTO.okWithData(response));
    }
}

