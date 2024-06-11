package com.FC.SharedOfficePlatform.domain.community.dto.response;


import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;

import java.time.LocalDateTime;

public record CommunityListResponse(
        Long boardId,
        long memberId,
        long officeId,
        String boardTitle,
        Long likesCount,
        Long commentCount,
        String memberNickname,
        String officeName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static CommunityListResponse from(
            FreeBoard freeBoard,
            Long likesCount,
            Long commentCount,
            String memberNickname,
            String officeName
    ) {
        return new CommunityListResponse(
                freeBoard.getBoardId(),
                freeBoard.getMemberId(),
                freeBoard.getOfficeId(),
                freeBoard.getBoardTitle(),
                likesCount,
                commentCount,
                memberNickname,
                officeName,
                freeBoard.getCreatedAt(),
                freeBoard.getUpdatedAt()
        );
    }
}
