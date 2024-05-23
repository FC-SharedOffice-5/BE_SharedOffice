package com.FC.SharedOfficePlatform.domain.inquiry.dto.request;

import com.FC.SharedOfficePlatform.domain.inquiry.entity.Inquiry;

public record InquiryRequest(
        long memberId,
        int inqType,
        String inqTitle,
        String inqContents,
        boolean inqResp
) {
    public Inquiry toEntity() {
        return Inquiry
                .builder()
                .memberId(memberId())
                .inqType(inqType())
                .inqTitle(inqTitle())
                .inqContents(inqContents())
                .inqResp(inqResp())
                .build();
    }
}
