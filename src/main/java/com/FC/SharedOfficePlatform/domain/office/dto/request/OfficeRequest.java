package com.FC.SharedOfficePlatform.domain.office.dto.request;

import com.FC.SharedOfficePlatform.domain.office.entity.Office;

public record OfficeRequest(
        Long officeId,
        String officeName,
        String officeAddr,
        int officeFloor,
        String officeTime,
        int officeCapacity,
        int officeStudio,
        int officeMeeting,
        String officeLatitude,
        String officeLongitude,
        String officeFacilities
) {
    public Office toEntity() {
        return Office
                .builder()
                .officeName(officeName())
                .officeAddr(officeAddr())
                .officeFloor(officeFloor())
                .officeTime(officeTime())
                .officeCapacity(officeCapacity())
                .officeStudio(officeStudio())
                .officeMeeting(officeMeeting())
                .officeLatitude(officeLatitude())
                .officeLongitude(officeLongitude())
                .officeFacilities(officeFacilities())
                .build();
    }
}
