package com.FC.SharedOfficePlatform.domain.comment.dto.request;

import com.FC.SharedOfficePlatform.domain.comment.entity.Comment;

public record CommentRequest(
        long memberId,
        long linkId,
        int linkCategory,
        String commentWrite
) {
    public Comment toEntity() {
        return Comment
                .builder()
                .memberId(memberId())
                .linkId(linkId())
                .linkCategory(linkCategory())
                .commentWrite(commentWrite())
                .build();
    }
}
