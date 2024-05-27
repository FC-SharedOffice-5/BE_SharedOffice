package com.FC.SharedOfficePlatform.domain.business.dto.request;

import com.FC.SharedOfficePlatform.domain.business.entity.Business;
import java.time.LocalDate;

public record BusinessRequest(
        Long businessId,
        String businessName,
        String businessType,
        int businessNum,
        LocalDate businessContractStartDate,
        LocalDate businessContractEndDate,
        String businessCeo,
        String businessPhone,
        String businessContractPerson,
        String businessContractPhone
) {
    public Business toEntity() {
        return Business
                .builder()
                .businessName(businessName())
                .businessType(businessType())
                .businessNum(businessNum())
                .businessContractStartDate(businessContractStartDate())
                .businessContractEndDate(businessContractEndDate())
                .businessCeo(businessCeo())
                .businessPhone(businessPhone())
                .businessContractPerson(businessContractPerson())
                .businessContractPhone(businessContractPhone())
                .build();
    }
}
