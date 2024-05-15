package com.FC.SharedOfficePlatform.domain.user.controller;

import com.FC.SharedOfficePlatform.domain.user.dto.request.SignUpRequest;
import com.FC.SharedOfficePlatform.domain.user.dto.response.SignUpResponse;
import com.FC.SharedOfficePlatform.domain.user.service.UserService;
import global.util.ResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDTO<SignUpResponse>> signUp(
        @RequestBody @Valid SignUpRequest signUpRequest
    ) {
        SignUpResponse signUpResponse = userService.signUp(signUpRequest);
        return ResponseEntity.ok(ResponseDTO.okWithData(signUpResponse));
    }

}
