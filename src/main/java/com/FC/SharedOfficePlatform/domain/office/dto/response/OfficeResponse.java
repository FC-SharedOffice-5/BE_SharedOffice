package com.FC.SharedOfficePlatform.domain.office.dto.response;

import com.FC.SharedOfficePlatform.domain.office.entity.Office;

public record OfficeResponse(
        Long officeId,
        String officeName,
        String officeAddr,
        int officeFloor,
        String officeTime,
        int officeCapacity,
        int officeStudio,
        int officeMeeting,
        String officeLatitude,
        String officeLongitude
) {
    public static OfficeResponse from(Office office) {
        return new OfficeResponse(
                office.getOfficeId(),
                office.getOfficeName(),
                office.getOfficeAddr(),
                office.getOfficeFloor(),
                office.getOfficeTime(),
                office.getOfficeCapacity(),
                office.getOfficeStudio(),
                office.getOfficeMeeting(),
                office.getOfficeLatitude(),
                office.getOfficeLongitude()
        );
    }
}
