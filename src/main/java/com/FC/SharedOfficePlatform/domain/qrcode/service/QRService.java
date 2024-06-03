package com.FC.SharedOfficePlatform.domain.qrcode.service;

import com.FC.SharedOfficePlatform.domain.auth.exception.MemberNotFoundException;
import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.domain.member.repository.MemberRepository;
import com.FC.SharedOfficePlatform.domain.qrcode.dto.QRRequest;
import com.FC.SharedOfficePlatform.domain.qrcode.exception.InvalidQRCodeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QRService {

    private final MemberRepository memberRepository;

    public void ValidateQR (QRRequest qrRequest) {
        Member member = memberRepository.findByEmail(qrRequest.email())
            .orElseThrow(() -> new MemberNotFoundException());

        if (!member.getMemberName().equals(qrRequest.memberName()) || !member.getMemberNickname().equals(qrRequest.memberNickname())) {
            throw new InvalidQRCodeException();
        }
    }

}
