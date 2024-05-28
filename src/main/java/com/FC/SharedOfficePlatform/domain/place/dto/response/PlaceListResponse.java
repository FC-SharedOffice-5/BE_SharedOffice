package com.FC.SharedOfficePlatform.domain.place.dto.response;

import com.FC.SharedOfficePlatform.domain.office.dto.OfficeDto;
import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record PlaceListResponse(
        Long PlaceId,
        long officeId,
        OfficeDto office,
        int placeCategory,
        String placeName,
        int placeCapacity,
        String placeAddr,
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
                place.getPlaceAddr(),
                place.getPlaceStartDate(),
                place.getPlaceEndDate(),
                place.isPlaceBeamYn(),
                place.isPlaceVideoYn(),
                place.getCreatedAt(),
                place.getUpdatedAt()
        );
    }
}
