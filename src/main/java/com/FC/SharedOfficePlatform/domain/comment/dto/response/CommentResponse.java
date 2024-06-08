package com.FC.SharedOfficePlatform.domain.comment.dto.response;

import com.FC.SharedOfficePlatform.domain.comment.entity.Comment;

import java.time.LocalDateTime;

public record CommentResponse(
        Long commentId,
        long memberId,
        long linkId,
        int linkCategory,
        String commentWrite,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static CommentResponse from(Comment comment) {
        return new CommentResponse(
                comment.getCommentId(),
                comment.getMemberId(),
                comment.getLinkId(),
                comment.getLinkCategory(),
                comment.getCommentWrite(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}
