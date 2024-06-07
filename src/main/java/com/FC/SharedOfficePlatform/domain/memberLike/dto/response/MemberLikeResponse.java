package com.FC.SharedOfficePlatform.domain.memberLike.dto.response;

import com.FC.SharedOfficePlatform.domain.memberLike.entity.MemberLike;

public record MemberLikeResponse(
        Long likeId,
        long memberId,
        long linkCode,
        int linkCategory
) {
    public static MemberLikeResponse from(MemberLike memberLike) {
        return new MemberLikeResponse(
                memberLike.getLikeId(),
                memberLike.getMemberId(),
                memberLike.getLinkCode(),
                memberLike.getLinkCategory()
        );
    }
}
