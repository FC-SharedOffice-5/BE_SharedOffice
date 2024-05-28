package com.FC.SharedOfficePlatform.domain.place.dto.response;

import com.FC.SharedOfficePlatform.domain.office.dto.OfficeDto;
import com.FC.SharedOfficePlatform.domain.place.entity.Place;

import java.time.LocalTime;

public record PlaceDetailResponse(
        Long placeId,
        long officeId,
        OfficeDto office,
        int placeCategory,
        String placeName,
        int placeCapacity,
        String placeAddr,
        LocalTime placeStartDate,
        LocalTime placeEndDate,
        boolean placeBeamYn,
        boolean placeVideoYn
) {
    public static PlaceDetailResponse from(Place place) {
        return new PlaceDetailResponse(
                place.getPlaceId(),
                place.getOfficeId(),
                OfficeDto.from(place.getOffice()),
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
