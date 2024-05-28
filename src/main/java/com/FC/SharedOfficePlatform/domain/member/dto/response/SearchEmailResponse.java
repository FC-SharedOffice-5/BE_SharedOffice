package com.FC.SharedOfficePlatform.domain.member.dto.response;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;

public record SearchEmailResponse(
    String email
) {
    public static SearchEmailResponse from(Member member) {
        return new  SearchEmailResponse(
            member.getEmail()
        );
    }
}
