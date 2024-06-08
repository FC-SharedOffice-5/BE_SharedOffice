package com.FC.SharedOfficePlatform.domain.freeBoard.dto.response;

import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;

public record FreeBoardResponse(
        Long boardId,
        long memberId,
        long officeId,
        String docTitle,
        String docContents
) {
    public static FreeBoardResponse from(FreeBoard freeBoard) {
        return new FreeBoardResponse(
                freeBoard.getBoardId(),
                freeBoard.getMemberId(),
                freeBoard.getOfficeId(),
                freeBoard.getBoardTitle(),
                freeBoard.getBoardContents()
        );
    }
}
