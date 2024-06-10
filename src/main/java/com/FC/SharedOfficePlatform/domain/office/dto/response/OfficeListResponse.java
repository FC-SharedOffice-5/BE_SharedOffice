package com.FC.SharedOfficePlatform.domain.office.dto.response;

import com.FC.SharedOfficePlatform.domain.office.entity.Office;

import java.time.LocalDateTime;

public record OfficeListResponse(
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
        String officeFacilities,
        boolean memberLike,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static OfficeListResponse from(Office office, boolean memberLike) {
        return new OfficeListResponse(
                office.getOfficeId(),
                office.getOfficeName(),
                office.getOfficeAddr(),
                office.getOfficeFloor(),
                office.getOfficeTime(),
                office.getOfficeCapacity(),
                office.getOfficeStudio(),
                office.getOfficeMeeting(),
                office.getOfficeLatitude(),
                office.getOfficeLongitude(),
                office.getOfficeFacilities(),
                memberLike,
                office.getCreatedAt(),
                office.getUpdatedAt()
        );
    }
}
