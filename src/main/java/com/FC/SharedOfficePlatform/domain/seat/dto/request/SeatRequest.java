package com.FC.SharedOfficePlatform.domain.seat.dto.request;

import com.FC.SharedOfficePlatform.domain.seat.entity.Seat;

import java.time.LocalTime;

public record SeatRequest(
        long officeId,
        int seatFloor,
        int seatTotal
) {
    public Seat toEntity() {
        return Seat
                .builder()
                .officeId(officeId())
                .seatFloor(seatFloor())
                .seatTotal(seatTotal())
                .build();
    }
}
