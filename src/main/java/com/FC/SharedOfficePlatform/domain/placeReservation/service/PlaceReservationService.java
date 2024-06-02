package com.FC.SharedOfficePlatform.domain.placeReservation.service;

import com.FC.SharedOfficePlatform.domain.place.repository.PlaceRepository;
import com.FC.SharedOfficePlatform.domain.placeReservation.dto.request.PlaceReservationRequest;
import com.FC.SharedOfficePlatform.domain.placeReservation.dto.response.PlaceReservationListResponse;
import com.FC.SharedOfficePlatform.domain.placeReservation.dto.response.PlaceReservationResponse;
import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservationRequestEntity;
import com.FC.SharedOfficePlatform.domain.placeReservation.repository.PlaceReservationRepository;
import com.FC.SharedOfficePlatform.domain.placeReservation.repository.PlaceReservationRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlaceReservationService {

    private final PlaceRepository placeRepository;
    private final PlaceReservationRepository placeReservationRepository;
    private final PlaceReservationRequestRepository placeReservationRequestRepository;

    @Transactional(readOnly = true)
    public List<PlaceReservationListResponse> getDetailPlaceFloor(Long officeId, int placeFloor) {
        return placeReservationRepository.findByPlaceFloorAndOfficeId(officeId,placeFloor).stream()
                .map(PlaceReservationListResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public PlaceReservationResponse insertPlaceReservation(PlaceReservationRequest placeReservationRequest) {

        PlaceReservationRequestEntity placeReservationRequestEntity = placeReservationRequest.toEntity();
        PlaceReservationRequestEntity savePlaceReservationRequestEntity = placeReservationRequestRepository.save(placeReservationRequestEntity);
        return PlaceReservationResponse.from(savePlaceReservationRequestEntity);
    }

//    @Transactional(readOnly = true)
//    public Map<LocalDate, Map<Long, List<PlaceReservationListResponse>>> getAllPlaceReservation(Long memberId) {
//        // memberId로 장소 예약 목록을 조회하고, PlaceReservationListResponse로 매핑
//        List<PlaceReservationListResponse> responses = placeReservationRepository.findByMemberId(memberId).stream()
//                .map(PlaceReservationListResponse::from)
//                .collect(Collectors.toList());
//
//        // placeResStartDate의 LocalDate로 먼저 그룹화하고, 그 안에서 officeId로 다시 그룹화
//        Map<LocalDate, Map<Long, List<PlaceReservationListResponse>>> groupedByDateAndOfficeId = responses.stream()
//                .collect(Collectors.groupingBy(
//                        response -> response.placeResStartDate().toLocalDate(),
//                        Collectors.groupingBy(response -> response.place().office().officeId())
//                ));
//
//        return groupedByDateAndOfficeId;
//    }

    @Transactional(readOnly = true)
    public Map<LocalDate, Map<Long, List<PlaceReservationListResponse>>> getAllPlaceReservation(Long memberId) {
        // memberId로 장소 예약 목록을 조회하고, PlaceReservationListResponse로 매핑
        List<PlaceReservationListResponse> responses = placeReservationRepository.findByMemberId(memberId).stream()
                .map(PlaceReservationListResponse::from)
                .collect(Collectors.toList());

        // placeResStartDate의 날짜별로 그룹화하고, 최신 날짜순으로 정렬
        Map<LocalDate, Map<Long, List<PlaceReservationListResponse>>> groupedByDateAndOfficeId = responses.stream()
                .collect(Collectors.groupingBy(
                        response -> response.placeResStartDate().toLocalDate(),
                        TreeMap::new,  // TreeMap을 사용하여 정렬
                        Collectors.groupingBy(response -> response.place().office().officeId())
                ));

        // TreeMap을 최신 날짜순으로 정렬된 LinkedHashMap으로 변환
        Map<LocalDate, Map<Long, List<PlaceReservationListResponse>>> sortedByDate = new TreeMap<>(Comparator.reverseOrder());
        sortedByDate.putAll(groupedByDateAndOfficeId);

        return sortedByDate;
    }


}
