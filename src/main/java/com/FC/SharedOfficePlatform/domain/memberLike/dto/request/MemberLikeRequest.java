package com.FC.SharedOfficePlatform.domain.memberLike.dto.request;

import com.FC.SharedOfficePlatform.domain.memberLike.entity.MemberLike;

public record MemberLikeRequest(
        long memberId,
        long linkCode,
        int linkCategory
) {
    public MemberLike toEntity() {
        return MemberLike
                .builder()
                .memberId(memberId())
                .linkCode(linkCode())
                .linkCategory(linkCategory())
                .build();
    }
}
