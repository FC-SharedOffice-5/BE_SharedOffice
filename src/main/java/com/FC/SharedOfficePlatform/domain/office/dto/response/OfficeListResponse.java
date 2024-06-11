package com.FC.SharedOfficePlatform.domain.office.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OfficeListResponse {
    private Long officeId;
    private String officeName;
    private String officeTime;
    private int officeCapacity;
    private int officeStudio;
    private int officeMeeting;
    private String officeLatitude;
    private String officeLongitude;
    @Setter
    private List<String> officeFacilities;
    private boolean memberLike;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public OfficeListResponse(
            Long officeId,
            String officeName,
            String officeTime,
            int officeCapacity,
            int officeStudio,
            int officeMeeting,
            String officeLatitude,
            String officeLongitude,
            boolean memberLike,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.officeTime = officeTime;
        this.officeCapacity = officeCapacity;
        this.officeStudio = officeStudio;
        this.officeMeeting = officeMeeting;
        this.officeLatitude = officeLatitude;
        this.officeLongitude = officeLongitude;
        this.memberLike = memberLike;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
