package com.FC.SharedOfficePlatform.domain.freeBoard.dto.response;

import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;

public record FreeBoardDetailResponse(
        Long boardId,
        long memberId,
        long officeId,
        String docTitle,
        String docContents,
        Long likesCount,
        long memberLike
) {
    public static FreeBoardDetailResponse from(FreeBoard freeBoard, Long likesCount, long memberLike) {
        return new FreeBoardDetailResponse(
                freeBoard.getBoardId(),
                freeBoard.getMemberId(),
                freeBoard.getOfficeId(),
                freeBoard.getBoardTitle(),
                freeBoard.getBoardContents(),
                likesCount,
                memberLike
        );
    }
}
