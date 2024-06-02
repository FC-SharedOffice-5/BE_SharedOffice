package com.FC.SharedOfficePlatform.domain.seatReservation.dto.request;

import com.FC.SharedOfficePlatform.domain.seatReservation.entity.SeatReservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public record SeatReservationRequest(
        long seatId,
        Long memberId,
        String seatResNum,
        String seatResStartDate,
        String seatResEndDate
) {
    // 문자열을 LocalDateTime으로 변환하는 메서드
    private LocalDateTime parseToLocalDateTime(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            return LocalDateTime.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("잘못된 날짜 형식입니다: " + dateStr);
        }
    }

    public SeatReservation toEntity() {

        LocalDateTime seatResStartDateTime = parseToLocalDateTime(seatResStartDate);
        LocalDateTime seatResEndDateTime = parseToLocalDateTime(seatResEndDate);

        return SeatReservation
                .builder()
                .seatId(seatId())
                .memberId(memberId())
                .seatResNum(seatResNum())
                .seatResStartDate(seatResStartDateTime)
                .seatResEndDate(seatResEndDateTime)
                .build();
    }
}
