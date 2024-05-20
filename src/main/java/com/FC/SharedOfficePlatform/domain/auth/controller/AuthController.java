package com.FC.SharedOfficePlatform.domain.auth.controller;

import com.FC.SharedOfficePlatform.domain.auth.dto.request.LoginRequest;
import com.FC.SharedOfficePlatform.domain.auth.dto.response.LoginResponse;
import com.FC.SharedOfficePlatform.domain.auth.service.AuthService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<LoginResponse>> login(
        @Valid @RequestBody LoginRequest request
    ) {
        log.info("[API][POST] request url : /login");
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(ResponseDTO.okWithData(response));
    }
}
