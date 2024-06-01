package com.FC.SharedOfficePlatform.domain.placeReservation.entity;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "place_reservation")
@NoArgsConstructor
@Getter
public class PlaceReservation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_res_id", nullable = false)
    private Long placeResId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "place_res_category")
    private int placeResCategory;

    @Column(name = "place_res_start_date")
    private LocalDateTime placeResStartDate;

    @Column(name = "place_res_end_date")
    private LocalDateTime placeResEndDate;

    @Builder
    public PlaceReservation(
            Place place,
            Long memberId,
            int placeResCategory,
            LocalDateTime placeResStartDate,
            LocalDateTime placeResEndDate
    ) {
        this.place = place;
        this.memberId = memberId;
        this.placeResCategory = placeResCategory;
        this.placeResStartDate = placeResStartDate;
        this.placeResEndDate = placeResEndDate;
    }

}
