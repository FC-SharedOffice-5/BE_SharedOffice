package com.FC.SharedOfficePlatform.domain.member.dto.response;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.global.security.enums.AuthorityCode;

public record SignUpMemberResponse(
    String email,
    String userName,
    AuthorityCode authCode,
    int authCodeValue
) {
    public static SignUpMemberResponse from(Member member) {
        return new SignUpMemberResponse(
            member.getEmail(),
            member.getMemberName(),
            member.getAuthCode(),
            member.getAuthCode().getAuthCode()
        );
    }
}
