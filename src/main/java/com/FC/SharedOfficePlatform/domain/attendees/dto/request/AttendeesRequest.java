package com.FC.SharedOfficePlatform.domain.attendees.dto.request;

import com.FC.SharedOfficePlatform.domain.attendees.entity.Attendees;
import com.FC.SharedOfficePlatform.domain.schedule.entity.Schedule;

public record AttendeesRequest(
        long memberId,
        int attendeesCategory
) {
    public Attendees toEntity(Schedule schedule) {
        return Attendees
                .builder()
                .memberId(memberId)
                .attendeesCategory(attendeesCategory)
                .schedule(schedule)
                .build();
    }
}
