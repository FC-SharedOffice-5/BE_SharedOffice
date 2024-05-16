package com.FC.SharedOfficePlatform.domain.member.controller;

import com.FC.SharedOfficePlatform.domain.member.repository.MemberRepository;
import com.FC.SharedOfficePlatform.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;

}
