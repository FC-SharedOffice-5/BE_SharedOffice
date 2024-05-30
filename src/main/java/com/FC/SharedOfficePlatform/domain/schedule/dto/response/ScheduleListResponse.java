package com.FC.SharedOfficePlatform.domain.schedule.dto.response;

import com.FC.SharedOfficePlatform.domain.attendees.dto.request.AttendeesRequest;
import com.FC.SharedOfficePlatform.domain.attendees.dto.response.AttendeesResponse;
import com.FC.SharedOfficePlatform.domain.attendees.entity.Attendees;
import com.FC.SharedOfficePlatform.domain.schedule.entity.Schedule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record ScheduleListResponse(
        Long eventId,
        long memberId,
        long resId,
        int eventColor,
        String eventTitle,
        LocalDateTime eventStartDate,
        LocalDateTime eventEndDate,
        String eventLocation,
        Set<AttendeesResponse> attendees,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ScheduleListResponse from(Schedule schedule) {
        Set<AttendeesResponse> attendeesResponses = schedule.getAttendees().stream()
                .map(AttendeesResponse::from)
                .collect(Collectors.toSet());
        return new ScheduleListResponse(
                schedule.getEventId(),
                schedule.getMemberId(),
                schedule.getResId(),
                schedule.getEventColor(),
                schedule.getEventTitle(),
                schedule.getEventStartDate(),
                schedule.getEventEndDate(),
                schedule.getEventLocation(),
                attendeesResponses,
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }
}
