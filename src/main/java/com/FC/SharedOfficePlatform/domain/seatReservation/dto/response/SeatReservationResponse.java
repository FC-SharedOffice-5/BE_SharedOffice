package com.FC.SharedOfficePlatform.domain.seatReservation.dto.response;

import com.FC.SharedOfficePlatform.domain.seat.dto.response.SeatResponse;
import com.FC.SharedOfficePlatform.domain.seatReservation.entity.SeatReservation;

import java.time.LocalDateTime;

public record SeatReservationResponse(
        Long seatResId,
        long seatId,
        Long memberId,
        String seatResNum,
        LocalDateTime seatResStartDate,
        LocalDateTime seatResEndDate
) {
    public static SeatReservationResponse from(SeatReservation seatReservation) {
        return new SeatReservationResponse(
                seatReservation.getSeatResId(),
                seatReservation.getSeatId(),
                seatReservation.getMemberId(),
                seatReservation.getSeatResNum(),
                seatReservation.getSeatResStartDate(),
                seatReservation.getSeatResEndDate()
        );
    }
}
