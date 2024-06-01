package com.FC.SharedOfficePlatform.domain.place.service;

import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeListResponse;
import com.FC.SharedOfficePlatform.domain.place.dto.PlaceFloorStats;
import com.FC.SharedOfficePlatform.domain.place.dto.request.PlaceRequest;
import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceDetailResponse;
import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceListResponse;
import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceResponse;
import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import com.FC.SharedOfficePlatform.domain.place.exception.PlaceNotFoundException;
import com.FC.SharedOfficePlatform.domain.place.repository.PlaceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Transactional
    public PlaceResponse insertPlace(PlaceRequest PlaceRequest) {
        Place place = PlaceRequest.toEntity();
        Place savePlace = placeRepository.save(place);
        return PlaceResponse.from(savePlace);
    }

    @Transactional(readOnly = true)
    public List<PlaceFloorStats> getAllPlaceFloorStats(long officeId) {
        return placeRepository.findPlaceFloorStatistics(officeId);
    }

    @Transactional(readOnly = true)
    public List<PlaceDetailResponse> getDetailPlaceFloor(int placeFloor) {
        return placeRepository.findByPlaceFloor(placeFloor).stream()
                .map(PlaceDetailResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PlaceDetailResponse getDetailPlace(Long placeId) {
        Place Place = placeRepository.findById(placeId)
                .orElseThrow(() -> {
                    log.error("Place with ID {} not found", placeId); // 로그 추가
                    return new PlaceNotFoundException("Place with ID " + placeId + " not found");
                });
        return PlaceDetailResponse.from(Place);
    }

}
