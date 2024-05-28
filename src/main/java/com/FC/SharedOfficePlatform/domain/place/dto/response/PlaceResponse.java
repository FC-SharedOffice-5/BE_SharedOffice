package com.FC.SharedOfficePlatform.domain.place.dto.response;

import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import java.time.LocalTime;

public record PlaceResponse(
        Long placeId,
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
    public static PlaceResponse from(Place place) {
        return new PlaceResponse(
                place.getPlaceId(),
                place.getOfficeId(),
                place.getPlaceCategory(),
                place.getPlaceName(),
                place.getPlaceCapacity(),
                place.getPlaceAddr(),
                place.getPlaceStartDate(),
                place.getPlaceEndDate(),
                place.isPlaceBeamYn(),
                place.isPlaceVideoYn()
        );
    }
}
