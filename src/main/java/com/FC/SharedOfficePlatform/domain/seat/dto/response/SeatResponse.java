package com.FC.SharedOfficePlatform.domain.seat.dto.response;

import com.FC.SharedOfficePlatform.domain.seat.entity.Seat;

public record SeatResponse(
        Long seatId,
        long officeId,
        int seatFloor,
        int seatTotal
) {
    public static SeatResponse from(Seat seat) {
        return new SeatResponse(
                seat.getSeatId(),
                seat.getOfficeId(),
                seat.getSeatFloor(),
                seat.getSeatTotal()
        );
    }
}
