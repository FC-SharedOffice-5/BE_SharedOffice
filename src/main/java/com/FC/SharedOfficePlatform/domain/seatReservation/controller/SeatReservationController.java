package com.FC.SharedOfficePlatform.domain.seatReservation.controller;


import com.FC.SharedOfficePlatform.domain.seatReservation.dto.request.SeatReservationRequest;
import com.FC.SharedOfficePlatform.domain.seatReservation.dto.response.SeatReservationListResponse;
import com.FC.SharedOfficePlatform.domain.seatReservation.dto.response.SeatReservationDeatilResponse;
import com.FC.SharedOfficePlatform.domain.seatReservation.dto.response.SeatReservationResponse;
import com.FC.SharedOfficePlatform.domain.seatReservation.service.SeatReservationService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offices/seats/reservations")
public class SeatReservationController {

    private final SeatReservationService seatReservationService;

    @GetMapping("/{officeId}")
    public ResponseEntity<ResponseDTO<List<SeatReservationListResponse>>> getListSeatReservationFloor(@PathVariable long officeId, @RequestParam int seatFloor) {
        List<SeatReservationListResponse> seatReservationResponses = seatReservationService.getListSeatReservationFloor(officeId, seatFloor);
        return ResponseEntity.ok(ResponseDTO.okWithData(seatReservationResponses));
    }

    @PostMapping
    public ResponseEntity<SeatReservationResponse> insertSeatReservation(@RequestBody SeatReservationRequest request) {
        SeatReservationResponse placeResponse = seatReservationService.insertSeatReservation(request);
        return new ResponseEntity<>(placeResponse, HttpStatus.CREATED);
    }
}
