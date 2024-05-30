package com.FC.SharedOfficePlatform.domain.member.service;

import com.FC.SharedOfficePlatform.domain.auth.exception.MemberNotFoundException;
import com.FC.SharedOfficePlatform.domain.member.dto.request.UpdateMyInfoRequest;
import com.FC.SharedOfficePlatform.domain.member.dto.response.MyInfoResponse;
import com.FC.SharedOfficePlatform.domain.member.dto.response.UpdateMyInfoResponse;
import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final MemberRepository memberRepository;

    public MyInfoResponse getMyInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new MemberNotFoundException());
        return MyInfoResponse.from(member);
    }

    @Transactional
    public UpdateMyInfoResponse updateMyInfo(Long id, UpdateMyInfoRequest request) {
        Member member = memberRepository.findById(id)
            .orElseThrow(() -> new MemberNotFoundException());
        member.updateMyInfo(request.memberName(), request.memberNickname(), request.memberBirth());
        Member updatedMember = memberRepository.save(member);
        return UpdateMyInfoResponse.from(updatedMember);
    }
}
