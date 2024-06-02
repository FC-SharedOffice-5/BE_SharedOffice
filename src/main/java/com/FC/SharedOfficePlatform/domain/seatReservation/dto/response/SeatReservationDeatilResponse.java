package com.FC.SharedOfficePlatform.domain.seatReservation.dto.response;

import com.FC.SharedOfficePlatform.domain.seat.dto.response.SeatResponse;
import com.FC.SharedOfficePlatform.domain.seatReservation.entity.SeatReservation;

import java.time.LocalDateTime;

public record SeatReservationDeatilResponse(
        Long seatResId,
        SeatResponse seat,
        Long memberId,
        String seatResNum,
        LocalDateTime seatResStartDate,
        LocalDateTime seatResEndDate
) {
    public static SeatReservationDeatilResponse from(SeatReservation seatReservation) {
        return new SeatReservationDeatilResponse(
                seatReservation.getSeatResId(),
                SeatResponse.from(seatReservation.getSeat()),
                seatReservation.getMemberId(),
                seatReservation.getSeatResNum(),
                seatReservation.getSeatResStartDate(),
                seatReservation.getSeatResEndDate()
        );
    }
}
