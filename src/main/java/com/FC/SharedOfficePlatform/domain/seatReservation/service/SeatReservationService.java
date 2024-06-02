package com.FC.SharedOfficePlatform.domain.seatReservation.service;

import com.FC.SharedOfficePlatform.domain.member.repository.MemberRepository;
import com.FC.SharedOfficePlatform.domain.seatReservation.dto.request.SeatReservationRequest;
import com.FC.SharedOfficePlatform.domain.seatReservation.dto.response.SeatReservationListResponse;
import com.FC.SharedOfficePlatform.domain.seatReservation.dto.response.SeatReservationDeatilResponse;
import com.FC.SharedOfficePlatform.domain.seatReservation.dto.response.SeatReservationResponse;
import com.FC.SharedOfficePlatform.domain.seatReservation.entity.SeatReservation;
import com.FC.SharedOfficePlatform.domain.seatReservation.repository.SeatReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeatReservationService {

    private final MemberRepository memberRepository;
    private final SeatReservationRepository seatReservationRepository;

//    @Transactional(readOnly = true)
//    public List<SeatReservationListResponse> getListSeatReservationFloor(int seatFloor) {
//        return seatReservationRepository.findBySeatFloor(seatFloor).stream()
//                .map(SeatReservationListResponse::from)
//                .collect(Collectors.toList());
//    }

    @Transactional(readOnly = true)
    public List<SeatReservationListResponse> getListSeatReservationFloor(long officeId, int seatFloor) {
        return seatReservationRepository.findBySeatFloorAndOfficeId(officeId, seatFloor).stream()
                .map(SeatReservationListResponse::from)
                .collect(Collectors.toList());
    }


    @Transactional
    public SeatReservationResponse insertSeatReservation(SeatReservationRequest seatReservationRequest) {
        SeatReservation seatReservation = seatReservationRequest.toEntity();
        SeatReservation saveSeatReservation = seatReservationRepository.save(seatReservation);
        return SeatReservationResponse.from(saveSeatReservation);
    }

    @Transactional(readOnly = true)
    public List<SeatReservationListResponse> getListSeatReservation(Long memberId) {
        return seatReservationRepository.findByMemberId(memberId).stream()
                .map(SeatReservationListResponse::from)
                .collect(Collectors.toList());
    }

//    @Transactional(readOnly = true)
//    public Map<Long, List<SeatReservationListResponse>> getAllPlaceReservation(Long memberId) {
//        // memberId로 장소 예약 목록을 조회하고, PlaceReservationListResponse로 매핑
//        List<SeatReservationListResponse> responses = seatReservationRepository.findByMemberId(memberId).stream()
//                .map(SeatReservationListResponse::from)
//                .collect(Collectors.toList());
//
////        // officeId로 그룹화
////        Map<Long, List<SeatReservationListResponse>> groupedByOfficeId = responses.stream()
////                .collect(Collectors.groupingBy(response -> response.place().office().officeId()));
//
//        return groupedByOfficeId;
//    }

}
