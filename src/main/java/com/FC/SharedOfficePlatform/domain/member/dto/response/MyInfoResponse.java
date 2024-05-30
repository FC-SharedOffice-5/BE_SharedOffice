package com.FC.SharedOfficePlatform.domain.member.dto.response;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.global.security.enums.Role;
import java.time.LocalDate;

public record MyInfoResponse(
    Role role,
    String memberName,
    String memberNickname,
    LocalDate memberBirth
) {
    public static MyInfoResponse from(Member member) {
        return new MyInfoResponse(
            member.getRole(),
            member.getMemberName(),
            member.getMemberNickname(),
            member.getMemberBirth()
        );
    }
}
