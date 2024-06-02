package com.FC.SharedOfficePlatform.domain.placeReservation.controller;

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

@RestController
@RequiredArgsConstructor
@RequestMapping("/offices/places/reservations")
public class PlaceReservationController {

    private final PlaceReservationService placeReservationService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<PlaceReservationListResponse>>> getDetailPlaceFloor(@RequestParam Long officeId, @RequestParam int placeFloor) {
        List<PlaceReservationListResponse> placeDetailResponse = placeReservationService.getDetailPlaceFloor(officeId, placeFloor);
        return ResponseEntity.ok(ResponseDTO.okWithData(placeDetailResponse));
    }

    @PostMapping
    public ResponseEntity<PlaceReservationResponse> insertPlaceReservation(@RequestBody PlaceReservationRequest request) {
        PlaceReservationResponse placeResponse = placeReservationService.insertPlaceReservation(request);
        return new ResponseEntity<>(placeResponse, HttpStatus.CREATED);
    }



}
