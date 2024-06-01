package com.FC.SharedOfficePlatform.domain.placeReservation.dto.request;

import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservationRequestEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public record PlaceReservationRequest(
        long placeId,
        long memberId,
        int placeResCategory,
        String placeResStartDate,
        String placeResEndDate
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

    public PlaceReservationRequestEntity toEntity() {

        LocalDateTime placeResStartDateTime = parseToLocalDateTime(placeResStartDate);
        LocalDateTime placeResEndDateTime = parseToLocalDateTime(placeResEndDate);

        return PlaceReservationRequestEntity
                .builder()
                .placeId(placeId())
                .mameberId(memberId())
                .placeResCategory(placeResCategory())
                .placeResStartDate(placeResStartDateTime)
                .placeResEndDate(placeResEndDateTime)
                .build();
    }
}
