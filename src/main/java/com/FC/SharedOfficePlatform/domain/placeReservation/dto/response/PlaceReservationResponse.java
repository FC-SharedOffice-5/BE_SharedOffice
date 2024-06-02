package com.FC.SharedOfficePlatform.domain.placeReservation.dto.response;

import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservationRequestEntity;

import java.time.LocalDateTime;

public record PlaceReservationResponse(
        Long placeResId,
        long placeId,
        long memberId,
        int placeResCategory,
        LocalDateTime placeResStartDate,
        LocalDateTime placeResEndDate
) {
    public static PlaceReservationResponse from(PlaceReservationRequestEntity placeReservation) {
        return new PlaceReservationResponse(
                placeReservation.getPlaceResId(),
                placeReservation.getPlaceId(),
                placeReservation.getMemberId(),
                placeReservation.getPlaceResCategory(),
                placeReservation.getPlaceResStartDate(),
                placeReservation.getPlaceResEndDate()
        );
    }
}
