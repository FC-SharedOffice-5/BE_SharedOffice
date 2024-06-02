package com.FC.SharedOfficePlatform.domain.placeReservation.controller;

import com.FC.SharedOfficePlatform.domain.placeReservation.dto.response.PlaceReservationListResponse;
import com.FC.SharedOfficePlatform.domain.placeReservation.service.PlaceReservationService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage/offices/places/reservations")
@Slf4j
public class PlaceReservationMyPageController {

    private final PlaceReservationService placeReservationService;

    @GetMapping
    public ResponseEntity<ResponseDTO<Map<LocalDate, Map<Long, List<PlaceReservationListResponse>>>>> getAllPlaceReservation(Long memberId) {
        Map<LocalDate, Map<Long, List<PlaceReservationListResponse>>> placeReservationDetail = placeReservationService.getAllPlaceReservation(memberId);
        return ResponseEntity.ok(ResponseDTO.okWithData(placeReservationDetail));
    }

//    public ResponseEntity<ResponseDTO<List<PlaceReservationListResponse>>> getAllPlaceReservation(Long memberId) {
//        List<PlaceReservationListResponse> placeReservationDetail = placeReservationService.getAllPlaceReservation(memberId);
//        return ResponseEntity.ok(ResponseDTO.okWithData(placeReservationDetail));
//    }

}
