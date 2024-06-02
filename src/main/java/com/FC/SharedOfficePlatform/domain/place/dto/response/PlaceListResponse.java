package com.FC.SharedOfficePlatform.domain.place.dto.response;

import com.FC.SharedOfficePlatform.domain.office.dto.OfficeDto;
import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record PlaceListResponse(
        Long placeId,
        long officeId,
        OfficeDto office,
        int placeCategory,
        String placeName,
        int placeCapacity,
        int placeFloor,
        LocalTime placeStartDate,
        LocalTime placeEndDate,
        boolean placeBeamYn,
        boolean placeVideoYn,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static PlaceListResponse from(Place place) {
        return new PlaceListResponse(
                place.getPlaceId(),
                place.getOfficeId(),
                OfficeDto.from(place.getOffice()),
                place.getPlaceCategory(),
                place.getPlaceName(),
                place.getPlaceCapacity(),
                place.getPlaceFloor(),
                place.getPlaceStartDate(),
                place.getPlaceEndDate(),
                place.isPlaceBeamYn(),
                place.isPlaceVideoYn(),
                place.getCreatedAt(),
                place.getUpdatedAt()
        );
    }
}
