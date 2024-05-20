package com.FC.SharedOfficePlatform.domain.auth.service;

import com.FC.SharedOfficePlatform.domain.auth.dto.request.LoginRequest;
import com.FC.SharedOfficePlatform.domain.auth.dto.response.LoginResponse;
import com.FC.SharedOfficePlatform.domain.auth.exception.InvalidPasswordException;
import com.FC.SharedOfficePlatform.domain.auth.exception.RegisteredEmailNotFoundException;
import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.domain.member.repository.MemberRepository;
import com.FC.SharedOfficePlatform.global.security.JwtService;
import com.FC.SharedOfficePlatform.global.security.MemberDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationProvider authenticationProvider;
    private final MemberRepository memberRepository;
    private final JwtService jwtService;

    @Transactional
    public LoginResponse login(LoginRequest request) {
        if (!memberRepository.existsByEmail(request.email())) {
            throw new RegisteredEmailNotFoundException();
        }
        try {
            Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
            );
            MemberDetails memberDetails = (MemberDetails) authentication.getPrincipal();
            Member member = memberRepository.getReferenceById(memberDetails.getId());

            String accessToken = jwtService.issueAccessToken(member.getId(), member.getEmail(), member.getAuthCode());
            return LoginResponse.from(accessToken);
        } catch (AuthenticationException e) {
            throw new InvalidPasswordException();
        }
    }
}
