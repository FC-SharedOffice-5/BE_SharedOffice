package com.FC.SharedOfficePlatform.domain.business.dto.response;

import com.FC.SharedOfficePlatform.domain.business.entity.Business;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record BusinessListResponse(
        Long businessId,
        String businessName,
        String businessType,
        int businessNum,
        LocalDate businessContractStartDate,
        LocalDate businessContractEndDate,
        String businessCeo,
        String businessPhone,
        String businessContractPerson,
        String businessContractPhone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static BusinessListResponse from(Business business) {
        return new BusinessListResponse(
                business.getBusinessId(),
                business.getBusinessName(),
                business.getBusinessType(),
                business.getBusinessNum(),
                business.getBusinessContractStartDate(),
                business.getBusinessContractEndDate(),
                business.getBusinessCeo(),
                business.getBusinessPhone(),
                business.getBusinessContractPerson(),
                business.getBusinessContractPhone(),
                business.getCreatedAt(),
                business.getUpdatedAt()
        );
    }
}
