package com.FC.SharedOfficePlatform.domain.seat.controller;

import com.FC.SharedOfficePlatform.domain.seat.dto.request.SeatRequest;
import com.FC.SharedOfficePlatform.domain.seat.dto.response.SeatListResponse;
import com.FC.SharedOfficePlatform.domain.seat.dto.response.SeatResponse;
import com.FC.SharedOfficePlatform.domain.seat.service.SeatService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offices/seats")
public class SeatController {

    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<SeatResponse> insertSeat(@RequestBody SeatRequest request) {
        SeatResponse seatResponse = seatService.insertSeat(request);
        return new ResponseEntity<>(seatResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{officeId}")
    public ResponseEntity<ResponseDTO<List<SeatListResponse>>> getListSeat(@PathVariable Long officeId) {
        List<SeatListResponse> seatListResponses = seatService.getListSeat(officeId);
        return ResponseEntity.ok(ResponseDTO.okWithData(seatListResponses));
    }

}
