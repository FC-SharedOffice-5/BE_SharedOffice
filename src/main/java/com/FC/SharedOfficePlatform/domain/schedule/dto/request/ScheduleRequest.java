package com.FC.SharedOfficePlatform.domain.schedule.dto.request;

import com.FC.SharedOfficePlatform.domain.attendees.dto.request.AttendeesRequest;
import com.FC.SharedOfficePlatform.domain.schedule.entity.Schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;


public record ScheduleRequest(
        long memberId,
        long resId,
        int eventColor,
        String eventTitle,
        String eventStartDate,
        String eventEndDate,
        String eventLocation,
        String eventMemo,
        List<AttendeesRequest> attendeesList
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

    public Schedule toEntity() {

        LocalDateTime eventStartDateTime = parseToLocalDateTime(eventStartDate);
        LocalDateTime eventEndDateTime = parseToLocalDateTime(eventEndDate);

        return Schedule
                .builder()
                .memberId(memberId)
                .resId(resId)
                .eventColor(eventColor)
                .eventTitle(eventTitle)
                .eventStartDate(eventStartDateTime)
                .eventEndDate(eventEndDateTime)
                .eventLocation(eventLocation)
                .eventMemo(eventMemo)
                .build();
    }
}
