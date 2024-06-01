package com.FC.SharedOfficePlatform.domain.attendees.entity;

import com.FC.SharedOfficePlatform.domain.schedule.entity.Schedule;
import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendees")
@NoArgsConstructor
@Getter
public class Attendees extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendees_id", nullable = false)
    private Long attendeesId;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "attendees_category", nullable = false)
    private int attendeesCategory;

    @ManyToOne
    @JoinColumn(name = "attendees_code", nullable = false)
    private Schedule schedule;


    @Builder
    public Attendees(
            long memberId,
            int attendeesCategory,
            Schedule schedule
    ) {
        this.memberId = memberId;
        this.attendeesCategory = attendeesCategory;
        this.schedule = schedule;
    }

}
