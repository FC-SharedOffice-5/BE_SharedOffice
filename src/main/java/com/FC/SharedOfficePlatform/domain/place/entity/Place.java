package com.FC.SharedOfficePlatform.domain.place.entity;

import com.FC.SharedOfficePlatform.domain.office.entity.Office;
import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "place")
@NoArgsConstructor
@Getter
public class Place extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id", nullable = false)
    private Long placeId;

    @ManyToOne
    @JoinColumn(name = "office_id", nullable = false, insertable = false, updatable = false)
    private Office office;

    @Column(name = "office_id", nullable = false)
    private long officeId;

    @Column(name = "place_category")
    private int placeCategory;

    @Column(name = "place_name", length = 20)
    private String placeName;

    @Column(name = "place_capacity")
    private int placeCapacity;

    @Column(name = "place_addr" , length = 20)
    private String placeAddr;

    @Column(name = "place_start_date")
    private LocalTime placeStartDate;

    @Column(name = "place_end_date")
    private LocalTime placeEndDate;

    @Column(name = "place_beam_yn", nullable = false, columnDefinition = "TINYINT")
    private boolean placeBeamYn;

    @Column(name = "place_video_yn", nullable = false, columnDefinition = "TINYINT")
    private boolean placeVideoYn;

    @Builder
    public Place(
            long officeId,
            int placeCategory,
            String placeName,
            int placeCapacity,
            String placeAddr,
            LocalTime placeStartDate,
            LocalTime placeEndDate,
            boolean placeBeamYn,
            boolean placeVideoYn
    ) {
        this.officeId = officeId;
        this.placeCategory = placeCategory;
        this.placeName = placeName;
        this.placeCapacity = placeCapacity;
        this.placeAddr = placeAddr;
        this.placeStartDate = placeStartDate;
        this.placeEndDate = placeEndDate;
        this.placeBeamYn = placeBeamYn;
        this.placeVideoYn = placeVideoYn;
    }

}
