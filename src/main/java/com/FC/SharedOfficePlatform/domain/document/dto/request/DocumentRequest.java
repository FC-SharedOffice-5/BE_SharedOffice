package com.FC.SharedOfficePlatform.domain.document.dto.request;

import com.FC.SharedOfficePlatform.domain.document.entity.Document;

public record DocumentRequest(
        long memberId,
        int docCategory,
        int docOfficeId,
        String docTitle,
        String docContents
) {
    public Document toEntity() {
        return Document
                .builder()
                .memberId(memberId())
                .docCategory(docCategory())
                .docOfficeId(docOfficeId())
                .docTitle(docTitle())
                .docContents(docContents())
                .build();
    }
}
