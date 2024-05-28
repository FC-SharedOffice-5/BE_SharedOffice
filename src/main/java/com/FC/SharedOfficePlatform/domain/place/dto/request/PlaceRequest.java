package com.FC.SharedOfficePlatform.domain.place.dto.request;

import com.FC.SharedOfficePlatform.domain.office.entity.Office;
import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record PlaceRequest(
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
    public Place toEntity() {
        return Place
                .builder()
                .officeId(officeId())
                .placeCategory(placeCategory())
                .placeName(placeName())
                .placeCapacity(placeCapacity())
                .placeAddr(placeAddr())
                .placeStartDate(placeStartDate())
                .placeEndDate(placeEndDate())
                .placeBeamYn(placeBeamYn())
                .placeVideoYn(placeVideoYn())
                .build();
    }
}
