package com.FC.SharedOfficePlatform.domain.member.service;

import com.FC.SharedOfficePlatform.domain.member.dto.request.SignUpMemberRequest;
import com.FC.SharedOfficePlatform.domain.member.dto.response.SignUpMemberResponse;
import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.domain.member.exception.MemberAlreadyRegisteredException;
import com.FC.SharedOfficePlatform.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignUpMemberResponse registerNewMember(SignUpMemberRequest request) {
        log.info("{} ::: {}", getClass().getSimpleName(), "registerNewMember");

        // 이메일 중복 검증
        if (memberRepository.existsByEmail(request.email())) {
            throw new MemberAlreadyRegisteredException();
        }
        // 패스워드 인코딩
        Member member = request.toEntity(request.password());
        member.setEncodedPassword(passwordEncoder.encode(request.password()));

        // 패스워드 인코딩한 유저 등록 (save())
        Member savedUser = memberRepository.save(member);
        SignUpMemberResponse signUpMemberResponse = SignUpMemberResponse.from(savedUser);
        return signUpMemberResponse;
    }
}
