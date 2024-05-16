package com.FC.SharedOfficePlatform.domain.reservation.controller;

import com.FC.SharedOfficePlatform.domain.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ReservationController {

    private final ReservationService reservationService;

}
