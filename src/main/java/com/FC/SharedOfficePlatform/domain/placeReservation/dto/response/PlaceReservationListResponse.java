package com.FC.SharedOfficePlatform.domain.placeReservation.dto.response;

import com.FC.SharedOfficePlatform.domain.member.dto.response.SignUpMemberResponse;
import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceDetailResponse;
import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservation;

import java.time.LocalDateTime;

public record PlaceReservationListResponse(
        Long placeResId,
        PlaceDetailResponse place,
        Long memberId,
        int placeResCategory,
        LocalDateTime placeResStartDate,
        LocalDateTime placeResEndDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static PlaceReservationListResponse from(PlaceReservation placeReservation) {
        return new PlaceReservationListResponse(
                placeReservation.getPlaceResId(),
                PlaceDetailResponse.from(placeReservation.getPlace()),
                placeReservation.getMemberId(),
                placeReservation.getPlaceResCategory(),
                placeReservation.getPlaceResStartDate(),
                placeReservation.getPlaceResEndDate(),
                placeReservation.getCreatedAt(),
                placeReservation.getUpdatedAt()
        );
    }
}
