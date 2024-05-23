package com.FC.SharedOfficePlatform.domain.member.dto.response;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.global.security.enums.Role;

public record SignUpMemberResponse(
    String email,
    Role role,
    String memberName,
    String memberNickname
) {
    public static SignUpMemberResponse from(Member member) {
        return new SignUpMemberResponse(
            member.getEmail(),
            member.getRole(),
            member.getMemberName(),
            member.getMemberNickname()
        );
    }
}
