package com.FC.SharedOfficePlatform.domain.document.dto.response;

import com.FC.SharedOfficePlatform.domain.document.entity.Document;

import java.time.LocalDateTime;

public record DocumentListResponse(
        Long docId,
        long memberId,
        int docCategory,
        int docOfficeId,
        String docTitle,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static DocumentListResponse from(Document inquiry) {
        return new DocumentListResponse(
                inquiry.getDocId(),
                inquiry.getMemberId(),
                inquiry.getDocCategory(),
                inquiry.getDocOfficeId(),
                inquiry.getDocTitle(),
                inquiry.getCreatedAt(),
                inquiry.getUpdatedAt()
        );
    }
}
