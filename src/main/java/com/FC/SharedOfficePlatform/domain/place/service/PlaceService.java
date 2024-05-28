package com.FC.SharedOfficePlatform.domain.place.service;

import com.FC.SharedOfficePlatform.domain.office.dto.OfficeDto;
import com.FC.SharedOfficePlatform.domain.office.dto.request.OfficeRequest;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeListResponse;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeResponse;
import com.FC.SharedOfficePlatform.domain.office.entity.Office;
import com.FC.SharedOfficePlatform.domain.office.exception.OfficeNotFoundException;
import com.FC.SharedOfficePlatform.domain.place.dto.request.PlaceRequest;
import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceListResponse;
import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceResponse;
import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import com.FC.SharedOfficePlatform.domain.place.exception.PlaceNotFoundException;
import com.FC.SharedOfficePlatform.domain.place.repository.PlaceRepository;
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
    public List<PlaceListResponse> getAllPlace() {
        return placeRepository.findAll().stream()
                .map(PlaceListResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PlaceResponse getDetailPlace(Long PlaceId) {
        Place Place = placeRepository.findById(PlaceId)
                .orElseThrow(() -> {
                    log.error("Place with ID {} not found", PlaceId); // 로그 추가
                    return new PlaceNotFoundException("Inquiry with ID " + PlaceId + " not found");
                });
        return PlaceResponse.from(Place);
    }

}
