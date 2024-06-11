package com.FC.SharedOfficePlatform.domain.freeBoard.dto.response;

import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;

import java.time.LocalDateTime;

public record FreeBoardListResponse(
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
    public static FreeBoardListResponse from(FreeBoard freeBoard,Long likesCount, Long commentCount, String memberNickname, String officeName) {
        return new FreeBoardListResponse(
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
