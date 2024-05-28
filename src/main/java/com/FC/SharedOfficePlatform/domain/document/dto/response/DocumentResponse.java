package com.FC.SharedOfficePlatform.domain.document.dto.response;

import com.FC.SharedOfficePlatform.domain.document.entity.Document;

import java.time.LocalDateTime;

public record DocumentResponse(
        Long docId,
        long memberId,
        int docCategory,
        int docOfficeId,
        String docTitle,
        String docContent
) {
    public static DocumentResponse from(Document document) {
        return new DocumentResponse(
                document.getDocId(),
                document.getMemberId(),
                document.getDocCategory(),
                document.getDocOfficeId(),
                document.getDocTitle(),
                document.getDocContents()
        );
    }
}
