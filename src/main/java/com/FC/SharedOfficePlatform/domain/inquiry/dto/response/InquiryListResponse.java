package com.FC.SharedOfficePlatform.domain.inquiry.dto.response;

import com.FC.SharedOfficePlatform.domain.inquiry.entity.Inquiry;
import java.time.LocalDateTime;

public record InquiryListResponse(
        Long inqId,
        long memberId,
        int inqType,
        String inqTitle,
        boolean inqResp,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static InquiryListResponse from(Inquiry inquiry) {
        return new InquiryListResponse(
                inquiry.getInqId(),
                inquiry.getMemberId(),
                inquiry.getInqType(),
                inquiry.getInqTitle(),
                inquiry.isInqResp(),
                inquiry.getCreatedAt(),
                inquiry.getUpdatedAt()
        );
    }
}
