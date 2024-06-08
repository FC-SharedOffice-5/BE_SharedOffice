package com.FC.SharedOfficePlatform.domain.freeBoard.dto.request;

import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;

public record FreeBoardRequest(
        long memberId,
        long officeId,
        String boardTitle,
        String boardContents
) {
    public FreeBoard toEntity() {
        return FreeBoard
                .builder()
                .memberId(memberId())
                .officeId(officeId())
                .boardTitle(boardTitle())
                .boardContents(boardContents())
                .build();
    }
}
