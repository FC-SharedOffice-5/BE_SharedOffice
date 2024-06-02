package com.FC.SharedOfficePlatform.domain.placeReservation.entity;

import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "place_reservation")
@NoArgsConstructor
@Getter
public class PlaceReservationRequestEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_res_id", nullable = false)
    private Long placeResId;

    @Column(name = "place_id", nullable = false)
    private long placeId;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "place_res_category")
    private int placeResCategory;

    @Column(name = "place_res_start_date")
    private LocalDateTime placeResStartDate;

    @Column(name = "place_res_end_date")
    private LocalDateTime placeResEndDate;

    @Builder
    public PlaceReservationRequestEntity(
            long placeId,
            long mameberId,
            int placeResCategory,
            LocalDateTime placeResStartDate,
            LocalDateTime placeResEndDate
    ) {
        this.placeId = placeId;
        this.memberId = mameberId;
        this.placeResCategory = placeResCategory;
        this.placeResStartDate = placeResStartDate;
        this.placeResEndDate = placeResEndDate;
    }

}
