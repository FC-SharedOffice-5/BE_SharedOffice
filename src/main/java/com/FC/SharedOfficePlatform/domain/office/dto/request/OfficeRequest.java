package com.FC.SharedOfficePlatform.domain.office.dto.request;

import com.FC.SharedOfficePlatform.domain.office.entity.Office;

import java.util.List;

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
        List<String> officeFacilities,
        String officePhone
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
                .officePhone(officePhone())
                .build();
    }
}
