package com.FC.SharedOfficePlatform.domain.attendees.dto.response;

import com.FC.SharedOfficePlatform.domain.attendees.entity.Attendees;

public record AttendeesResponse(
        Long attendeesId,
        long attendeesCode,
        long memberId,
        int attendeesCategory

) {
    public static AttendeesResponse from(Attendees attendees) {
        return new AttendeesResponse(
                attendees.getAttendeesId(),
                attendees.getSchedule() != null ? attendees.getSchedule().getEventId() : null,
                attendees.getMemberId(),
                attendees.getAttendeesCategory()
        );
    }
}
