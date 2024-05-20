package com.FC.SharedOfficePlatform.domain.member.controller;

import com.FC.SharedOfficePlatform.domain.member.dto.request.SignUpMemberRequest;
import com.FC.SharedOfficePlatform.domain.member.dto.response.SignUpMemberResponse;
import com.FC.SharedOfficePlatform.domain.member.service.MemberService;
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
@RequestMapping("/signup")
@Slf4j
public class SignUpMemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<ResponseDTO<SignUpMemberResponse>> signUp(
        @RequestBody @Valid SignUpMemberRequest request
    ) {
        log.info("[API][POST] request url : /signup");

        SignUpMemberResponse response = memberService.registerNewMember(request);

        return ResponseEntity.ok(ResponseDTO.okWithData(response));
    }
}
