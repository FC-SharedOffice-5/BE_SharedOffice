package com.FC.SharedOfficePlatform.domain.business.dto.response;

import com.FC.SharedOfficePlatform.domain.business.entity.Business;
import java.time.LocalDate;

public record BusinessResponse(
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
    public static BusinessResponse from(Business business) {
        return new BusinessResponse(
                business.getBusinessId(),
                business.getBusinessName(),
                business.getBusinessType(),
                business.getBusinessNum(),
                business.getBusinessContractStartDate(),
                business.getBusinessContractEndDate(),
                business.getBusinessCeo(),
                business.getBusinessPhone(),
                business.getBusinessContractPerson(),
                business.getBusinessContractPhone()
        );
    }
}
