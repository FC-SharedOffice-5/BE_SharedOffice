package com.FC.SharedOfficePlatform.domain.seat.service;

import com.FC.SharedOfficePlatform.domain.place.dto.PlaceFloorStats;
import com.FC.SharedOfficePlatform.domain.seat.dto.request.SeatRequest;
import com.FC.SharedOfficePlatform.domain.seat.dto.response.SeatListResponse;
import com.FC.SharedOfficePlatform.domain.seat.dto.response.SeatResponse;
import com.FC.SharedOfficePlatform.domain.seat.entity.Seat;
import com.FC.SharedOfficePlatform.domain.seat.exception.SeatNotFoundException;
import com.FC.SharedOfficePlatform.domain.seat.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeatService {

    private final SeatRepository seatRepository;

    @Transactional
    public SeatResponse insertSeat(SeatRequest SeatRequest) {
        Seat seat = SeatRequest.toEntity();
        Seat saveSeat = seatRepository.save(seat);
        return SeatResponse.from(saveSeat);
    }

    @Transactional(readOnly = true)
    public List<SeatListResponse> getListSeat(Long officeId) {
        List<Seat> seats = seatRepository.findByOfficeId(officeId);
        return seats.stream()
                .map(SeatListResponse::from)
                .collect(Collectors.toList());
    }

}
