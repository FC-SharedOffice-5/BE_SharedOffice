package com.FC.SharedOfficePlatform.domain.member.service;

import com.FC.SharedOfficePlatform.domain.auth.exception.MemberNotFoundException;
import com.FC.SharedOfficePlatform.domain.member.dto.request.SignUpMemberRequest;
import com.FC.SharedOfficePlatform.domain.member.dto.request.UpdatePasswordRequest;
import com.FC.SharedOfficePlatform.domain.member.dto.response.SignUpMemberResponse;
import com.FC.SharedOfficePlatform.domain.member.dto.response.UpdatePasswordResponse;
import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.domain.member.exception.AlreadyUsedPasswordException;
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

        if (memberRepository.existsByEmail(request.email())) {
            throw new MemberAlreadyRegisteredException();
        }
        String encodedPassword = passwordEncoder.encode(request.password());
        Member member = request.toEntity(encodedPassword);
        Member savedMember = memberRepository.save(member);
        return SignUpMemberResponse.from(savedMember);
    }

    @Transactional
    public UpdatePasswordResponse updatePassword(String email, UpdatePasswordRequest request) {
        Member member = memberRepository.findByEmail(email)
            .orElseThrow(() -> new MemberNotFoundException());
        if (passwordEncoder.matches(request.password(), member.getPassword())) {
            throw new AlreadyUsedPasswordException();
        }
        String encodedPassword = passwordEncoder.encode(request.password());
        member.updatePassword(encodedPassword);
        memberRepository.save(member);
        return UpdatePasswordResponse.from(member);
    }
}
