package com.FC.SharedOfficePlatform.domain.comment.dto.response;

import com.FC.SharedOfficePlatform.domain.comment.entity.Comment;

import java.time.LocalDateTime;

public record CommentListResponse(
        Long commentId,
        long memberId,
        long linkId,
        int linkCategory,
        String commentWrite,
        Long likeCount,
        int memberLike,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
    public static CommentListResponse from(Comment comment, Long likeCount, int memberLike) {
        return new CommentListResponse(
                comment.getCommentId(),
                comment.getMemberId(),
                comment.getLinkId(),
                comment.getLinkCategory(),
                comment.getCommentWrite(),
                likeCount,
                memberLike,
                comment.getCreatedAt(),
                comment.getUpdatedAt()

        );
    }
}
