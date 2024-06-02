package com.FC.SharedOfficePlatform.domain.placeReservation.service;

import com.FC.SharedOfficePlatform.domain.member.repository.MemberRepository;
import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceDetailResponse;
import com.FC.SharedOfficePlatform.domain.place.repository.PlaceRepository;
import com.FC.SharedOfficePlatform.domain.placeReservation.dto.request.PlaceReservationRequest;
import com.FC.SharedOfficePlatform.domain.placeReservation.dto.response.PlaceReservationListResponse;
import com.FC.SharedOfficePlatform.domain.placeReservation.dto.response.PlaceReservationResponse;
import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservationRequestEntity;
import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservation;
import com.FC.SharedOfficePlatform.domain.placeReservation.exception.PlaceReservationNotFoundException;
import com.FC.SharedOfficePlatform.domain.placeReservation.repository.PlaceReservationRepository;
import com.FC.SharedOfficePlatform.domain.placeReservation.repository.PlaceReservationRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlaceReservationService {

    private final MemberRepository memberRepository;
    private final PlaceRepository placeRepository;
    private final PlaceReservationRepository placeReservationRepository;
    private final PlaceReservationRequestRepository placeReservationRequestRepository;

    @Transactional(readOnly = true)
    public List<PlaceDetailResponse> getDetailPlaceFloor(int placeFloor) {
        return placeRepository.findByPlaceFloor(placeFloor).stream()
                .map(PlaceDetailResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public PlaceReservationResponse insertPlaceReservation(PlaceReservationRequest placeReservationRequest) {

        PlaceReservationRequestEntity placeReservationRequestEntity = placeReservationRequest.toEntity();
        PlaceReservationRequestEntity savePlaceReservationRequestEntity = placeReservationRequestRepository.save(placeReservationRequestEntity);
        return PlaceReservationResponse.from(savePlaceReservationRequestEntity);
    }

//    @Transactional(readOnly = true)
//    public List<PlaceReservationListResponse> getAllPlaceReservation(Long memberId) {
//
//        return placeReservationRepository.findByMemberId(memberId).stream()
//                .map(PlaceReservationListResponse::from)
//                .collect(Collectors.toList());
//    }

    @Transactional(readOnly = true)
    public Map<Long, List<PlaceReservationListResponse>> getAllPlaceReservation(Long memberId) {
        // memberId로 장소 예약 목록을 조회하고, PlaceReservationListResponse로 매핑
        List<PlaceReservationListResponse> responses = placeReservationRepository.findByMemberId(memberId).stream()
                .map(PlaceReservationListResponse::from)
                .collect(Collectors.toList());

        // officeId로 그룹화
        Map<Long, List<PlaceReservationListResponse>> groupedByOfficeId = responses.stream()
                .collect(Collectors.groupingBy(response -> response.place().office().officeId()));

        return groupedByOfficeId;
    }

//    @Transactional(readOnly = true)
//    public PlaceReservationListResponse getDetailPlaceReservation(Long Id) {
//        PlaceReservation placeReservation = placeReservationRepository.findById(placeResId)
//                .orElseThrow(() -> {
//                    log.error("PlaceReservation with ID {} not found", placeResId); // 로그 추가
//                    return new PlaceReservationNotFoundException("PlaceReservation with ID " + placeResId + " not found");
//                });
//        return PlaceReservationListResponse.from(placeReservation);
//    }

}
