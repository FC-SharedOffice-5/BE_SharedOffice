package com.FC.SharedOfficePlatform.domain.member.dto.response;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;

public record UpdatePasswordResponse(
    String password
) {
    public static UpdatePasswordResponse from(Member member) {
        return new UpdatePasswordResponse(
            member.getPassword()
        );
    }

}
