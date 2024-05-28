package com.FC.SharedOfficePlatform.domain.office.dto;

import com.FC.SharedOfficePlatform.domain.office.entity.Office;

public record OfficeDto(
        Long officeId,
        String officeName,
        String officeAddr
) {
    public static OfficeDto from(Office office) {
        return new OfficeDto(
                office.getOfficeId(),
                office.getOfficeName(),
                office.getOfficeAddr()
        );
    }
}