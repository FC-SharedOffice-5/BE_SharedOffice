package com.FC.SharedOfficePlatform.domain.office.entity;

import com.FC.SharedOfficePlatform.domain.image.entity.ImageData;
import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "office")
@NoArgsConstructor
@Getter
public class Office extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id", nullable = false)
    private Long officeId;

    @Column(name = "office_name", length = 10, nullable = false)
    private String officeName;

    @Column(name = "office_addr", length = 100)
    private String officeAddr;

    @Column(name = "office_floor")
    private int officeFloor;

    @Column(name = "office_time", length = 10)
    private String officeTime;

    @Column(name = "office_capacity")
    private int officeCapacity;

    @Column(name = "office_studio")
    private int officeStudio;

    @Column(name = "office_meeting")
    private int officeMeeting;

    @Column(name = "office_latitude", length = 15)
    private String officeLatitude;

    @Column(name = "office_longitude", length = 15)
    private String officeLongitude;

    @ElementCollection
    @Column(name = "office_facilities", length = 100)
    private List<String> officeFacilities;

    @Column(name = "office_phone", length = 13)
    private String officePhone;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImageData> images = new ArrayList<>();

    @Builder
    public Office(
            String officeName,
            String officeAddr,
            int officeFloor,
            String officeTime,
            int officeCapacity,
            int officeStudio,
            int officeMeeting,
            String officeLatitude,
            String officeLongitude,
            List<ImageData> images,
            List<String> officeFacilities,
            String officePhone
    ) {
        this.officeName = officeName;
        this.officeAddr = officeAddr;
        this.officeFloor = officeFloor;
        this.officeTime = officeTime;
        this.officeCapacity = officeCapacity;
        this.officeStudio = officeStudio;
        this.officeMeeting = officeMeeting;
        this.officeLatitude = officeLatitude;
        this.officeLongitude = officeLongitude;
        this.images = images;
        this.officeFacilities = officeFacilities;
        this.officePhone = officePhone;
    }

    public String getFormattedOfficeFacilities() {
        return officeFacilities.stream()
                .map(facility -> "\"" + facility + "\"")
                .collect(Collectors.joining(", "));
    }

}
