package com.FC.SharedOfficePlatform.domain.schedule.dto.response;

import com.FC.SharedOfficePlatform.domain.attendees.dto.response.AttendeesResponse;
import com.FC.SharedOfficePlatform.domain.schedule.entity.Schedule;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record ScheduleResponse(
        Long eventId,
        long memberId,
        long resId,
        int eventColor,
        String eventTitle,
        LocalDateTime eventStartDate,
        LocalDateTime eventEndDate,
        String eventLocation,
        String eventMemo,
        Set<AttendeesResponse> attendees
) {
    public static ScheduleResponse from(Schedule schedule) {
        Set<AttendeesResponse> attendeesResponses = schedule.getAttendees().stream()
                .map(AttendeesResponse::from)
                .collect(Collectors.toSet());
        return new ScheduleResponse(
                schedule.getEventId(),
                schedule.getMemberId(),
                schedule.getResId(),
                schedule.getEventColor(),
                schedule.getEventTitle(),
                schedule.getEventStartDate(),
                schedule.getEventEndDate(),
                schedule.getEventLocation(),
                schedule.getEventMemo(),
                attendeesResponses
        );
    }
}
