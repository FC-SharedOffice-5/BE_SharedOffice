package com.FC.SharedOfficePlatform.domain.place.dto.request;

import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import java.time.LocalTime;

public record PlaceRequest(
        long officeId,
        int placeCategory,
        String placeName,
        int placeCapacity,
        int placeFloor,
        LocalTime placeStartDate,
        LocalTime placeEndDate,
        boolean placeBeamYn,
        boolean placeVideoYn
) {
    public Place toEntity() {
        return Place
                .builder()
                .officeId(officeId())
                .placeCategory(placeCategory())
                .placeName(placeName())
                .placeCapacity(placeCapacity())
                .placeFloor(placeFloor())
                .placeStartDate(placeStartDate())
                .placeEndDate(placeEndDate())
                .placeBeamYn(placeBeamYn())
                .placeVideoYn(placeVideoYn())
                .build();
    }
}
