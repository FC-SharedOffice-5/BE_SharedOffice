package com.FC.SharedOfficePlatform.domain.schedule.entity;

import com.FC.SharedOfficePlatform.domain.attendees.entity.Attendees;
import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event")
@NoArgsConstructor
@Getter
public class Schedule extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "res_id", nullable = false)
    private long resId;

    @Column(name = "event_color", nullable = false)
    private int eventColor;

    @Column(name = "event_title", length = 50)
    private String eventTitle;

    @Column(name = "event_start_date")
    private LocalDateTime eventStartDate;

    @Column(name = "event_end_date")
    private LocalDateTime eventEndDate;

    @Column(name = "event_location", length = 100)
    private String eventLocation;

    @Column(name = "event_memo", length = 5000)
    private String eventMemo;

    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
    private Set<Attendees> attendees = new HashSet<>();

    @Builder
    public Schedule(
            long memberId,
            long resId,
            int eventColor,
            String eventTitle,
            LocalDateTime eventStartDate,
            LocalDateTime eventEndDate,
            String eventLocation,
            String eventMemo
    ) {
        this.memberId = memberId;
        this.resId = resId;
        this.eventColor = eventColor;
        this.eventTitle = eventTitle;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.eventLocation = eventLocation;
        this.eventMemo = eventMemo;
        this.attendees = getAttendees();
    }

}
