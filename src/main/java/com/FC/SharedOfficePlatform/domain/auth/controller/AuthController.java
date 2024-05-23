package com.FC.SharedOfficePlatform.domain.auth.controller;

import com.FC.SharedOfficePlatform.domain.auth.dto.TokenDTO;
import com.FC.SharedOfficePlatform.domain.auth.dto.request.LoginRequest;
import com.FC.SharedOfficePlatform.domain.auth.service.AuthService;
import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.global.security.CookieUtils;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    public static final String ACCESS_TOKEN_COOKIE_NAME = "accessToken";

    private final CookieUtils cookieUtils;

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<Void>> login(
        @RequestBody @Valid LoginRequest request,
        HttpServletResponse httpServletResponse
    ) {
        Member member = authService.findByEmail(request.email());
        TokenDTO tokenDTO = authService.login(member, request);

        Cookie accessToken = cookieUtils.makeCookie(
            ACCESS_TOKEN_COOKIE_NAME, tokenDTO.accessToken()
        );
        httpServletResponse.addCookie(accessToken);

        return ResponseEntity.ok(ResponseDTO.ok());
    }

    @PostMapping("/logout")
    public ResponseEntity<ResponseDTO<Void>> logout(HttpServletResponse httpServletResponse) {
        Cookie expiredCookie = cookieUtils.expireCookie(ACCESS_TOKEN_COOKIE_NAME);
        httpServletResponse.addCookie(expiredCookie);

        return ResponseEntity.ok(ResponseDTO.ok());
    }
}
