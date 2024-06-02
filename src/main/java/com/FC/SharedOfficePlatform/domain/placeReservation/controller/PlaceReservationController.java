package com.FC.SharedOfficePlatform.domain.placeReservation.controller;

import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceDetailResponse;
import com.FC.SharedOfficePlatform.domain.placeReservation.dto.request.PlaceReservationRequest;
import com.FC.SharedOfficePlatform.domain.placeReservation.dto.response.PlaceReservationListResponse;
import com.FC.SharedOfficePlatform.domain.placeReservation.dto.response.PlaceReservationResponse;
import com.FC.SharedOfficePlatform.domain.placeReservation.service.PlaceReservationService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offices/places/reservations")
public class PlaceReservationController {

    private final PlaceReservationService placeReservationService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<PlaceDetailResponse>>> getDetailPlaceFloor(@RequestParam int placeFloor) {
        List<PlaceDetailResponse> placeDetailResponse = placeReservationService.getDetailPlaceFloor(placeFloor);
        return ResponseEntity.ok(ResponseDTO.okWithData(placeDetailResponse));
    }

    @PostMapping
    public ResponseEntity<PlaceReservationResponse> insertPlaceReservation(@RequestBody PlaceReservationRequest request) {
        PlaceReservationResponse placeResponse = placeReservationService.insertPlaceReservation(request);
        return new ResponseEntity<>(placeResponse, HttpStatus.CREATED);
    }



}
