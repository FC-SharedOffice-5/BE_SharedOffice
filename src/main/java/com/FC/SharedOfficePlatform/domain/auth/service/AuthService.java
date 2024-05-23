package com.FC.SharedOfficePlatform.domain.auth.service;

import com.FC.SharedOfficePlatform.domain.auth.dto.TokenDTO;
import com.FC.SharedOfficePlatform.domain.auth.dto.request.LoginRequest;
import com.FC.SharedOfficePlatform.domain.auth.exception.InvalidPasswordException;
import com.FC.SharedOfficePlatform.domain.auth.exception.MemberNotFoundException;
import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.domain.member.repository.MemberRepository;
import com.FC.SharedOfficePlatform.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public TokenDTO login(Member member, LoginRequest loginRequest) {
        if (!passwordEncoder.matches(loginRequest.password(), member.getPassword())) {
            throw new InvalidPasswordException();
        }
        String accessToken = jwtProvider.createToken(member);
        return new TokenDTO(accessToken);
    }

    public Member findByEmail(String email) {
        Member member = memberRepository.findByEmail(email)
            .orElseThrow(MemberNotFoundException::new);
        return member;
    }
}

