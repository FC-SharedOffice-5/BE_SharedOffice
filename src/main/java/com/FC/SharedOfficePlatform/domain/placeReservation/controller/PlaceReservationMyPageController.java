package com.FC.SharedOfficePlatform.domain.placeReservation.controller;

import com.FC.SharedOfficePlatform.domain.inquiry.dto.request.InquiryRequest;
import com.FC.SharedOfficePlatform.domain.inquiry.dto.response.InquiryListResponse;
import com.FC.SharedOfficePlatform.domain.inquiry.dto.response.InquiryResponse;
import com.FC.SharedOfficePlatform.domain.inquiry.service.InquiryService;
import com.FC.SharedOfficePlatform.domain.placeReservation.dto.response.PlaceReservationListResponse;
import com.FC.SharedOfficePlatform.domain.placeReservation.service.PlaceReservationService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage/offices/places/reservations")
@Slf4j
public class PlaceReservationMyPageController {

    private final PlaceReservationService placeReservationService;

    @GetMapping
    public ResponseEntity<ResponseDTO<Map<Long, List<PlaceReservationListResponse>>>> getAllPlaceReservation(Long memberId) {
        Map<Long, List<PlaceReservationListResponse>> placeReservationDetail = placeReservationService.getAllPlaceReservation(memberId);
        return ResponseEntity.ok(ResponseDTO.okWithData(placeReservationDetail));
    }

}
