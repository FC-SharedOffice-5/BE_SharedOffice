package com.FC.SharedOfficePlatform.domain.seat.dto.response;

import com.FC.SharedOfficePlatform.domain.office.dto.OfficeDto;
import com.FC.SharedOfficePlatform.domain.seat.entity.Seat;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record SeatListResponse(
        Long seatId,
        OfficeDto office,
        int seatFloor,
        int seatTotal,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static SeatListResponse from(Seat seat) {
        return new SeatListResponse(
                seat.getSeatId(),
                OfficeDto.from(seat.getOffice()),
                seat.getSeatFloor(),
                seat.getSeatTotal(),
                seat.getCreatedAt(),
                seat.getUpdatedAt()
        );
    }
}
