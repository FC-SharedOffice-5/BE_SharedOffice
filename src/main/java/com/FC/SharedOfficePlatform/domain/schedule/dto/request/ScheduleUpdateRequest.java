package com.FC.SharedOfficePlatform.domain.schedule.dto.request;

import com.FC.SharedOfficePlatform.domain.attendees.dto.request.AttendeesRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Getter
@Setter
public class ScheduleUpdateRequest {
    private long resId;
    private int eventColor;
    private String eventTitle;
    private String eventStartDate;
    private String eventEndDate;
    private String eventLocation;
    private String eventMemo;
    private List<AttendeesRequest> attendeesList;
}