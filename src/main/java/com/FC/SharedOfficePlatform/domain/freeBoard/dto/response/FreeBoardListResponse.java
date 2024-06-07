package com.FC.SharedOfficePlatform.domain.freeBoard.dto.response;

import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;

import java.time.LocalDateTime;

public record FreeBoardListResponse(
        Long boardId,
        long memberId,
        long officeId,
        String docTitle,
        Long likesCount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static FreeBoardListResponse from(FreeBoard freeBoard,Long likesCount) {
        return new FreeBoardListResponse(
                freeBoard.getBoardId(),
                freeBoard.getMemberId(),
                freeBoard.getOfficeId(),
                freeBoard.getBoardTitle(),
                likesCount,
                freeBoard.getCreatedAt(),
                freeBoard.getUpdatedAt()
        );
    }
}