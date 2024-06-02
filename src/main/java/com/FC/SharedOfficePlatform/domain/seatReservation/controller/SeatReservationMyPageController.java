package com.FC.SharedOfficePlatform.domain.seatReservation.controller;

import com.FC.SharedOfficePlatform.domain.seatReservation.dto.response.SeatReservationListResponse;
import com.FC.SharedOfficePlatform.domain.seatReservation.service.SeatReservationService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage/offices/seats/reservations")
@Slf4j
public class SeatReservationMyPageController {

    private final SeatReservationService seatReservationService;

    @GetMapping("/{memberId}")
    public ResponseEntity<ResponseDTO<List<SeatReservationListResponse>>> getListSeatReservation(@PathVariable Long memberId) {
        List<SeatReservationListResponse> seatReservationResponses = seatReservationService.getListSeatReservation(memberId);
        return ResponseEntity.ok(ResponseDTO.okWithData(seatReservationResponses));
    }

}
