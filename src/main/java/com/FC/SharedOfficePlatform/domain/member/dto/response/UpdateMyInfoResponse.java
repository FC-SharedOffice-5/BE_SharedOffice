package com.FC.SharedOfficePlatform.domain.member.dto.response;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import java.time.LocalDate;

public record UpdateMyInfoResponse(
    String memberName,
    String memberNickname,
    LocalDate memberBirth
) {
    public static UpdateMyInfoResponse from(Member member) {
        return new UpdateMyInfoResponse(
            member.getMemberName(),
            member.getMemberNickname(),
            member.getMemberBirth()
        );
    }
}
