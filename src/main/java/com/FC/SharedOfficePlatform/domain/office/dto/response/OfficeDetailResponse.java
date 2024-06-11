package com.FC.SharedOfficePlatform.domain.office.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class OfficeDetailResponse {
    private Long officeId;
    private String officeName;
    private String officeAddr;
    private int officeFloor;
    private String officeTime;
    private int officeCapacity;
    private int officeStudio;
    private int officeMeeting;
    private String officeLatitude;
    private String officeLongitude;
    @Setter
    private List<String> officeFacilities;
    private String officePhone;
    private boolean memberLike;

    public OfficeDetailResponse (
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
            String officePhone,
            boolean memberLike
    ) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.officeAddr = officeAddr;
        this.officeFloor = officeFloor;
        this.officeTime = officeTime;
        this.officeCapacity = officeCapacity;
        this.officeStudio = officeStudio;
        this.officeMeeting = officeMeeting;
        this.officeLatitude = officeLatitude;
        this.officeLongitude = officeLongitude;
        this.officePhone = officePhone;
        this.memberLike = memberLike;
    }
}
