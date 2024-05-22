package com.FC.SharedOfficePlatform.domain.inquiry.dto.response;

import com.FC.SharedOfficePlatform.domain.inquiry.entity.Inquiry;

public record InquiryResponse(
        Long inqId,
        long memberId,
        int inqType,
        String inqTitle,
        String inqContents,
        boolean inqResp
) {
    public static InquiryResponse from(Inquiry inquiry) {
        return new InquiryResponse(
                inquiry.getInqId(),
                inquiry.getMemberId(),
                inquiry.getInqType(),
                inquiry.getInqTitle(),
                inquiry.getInqContents(),
                inquiry.isInqResp()
        );
    }
}
