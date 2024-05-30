package com.FC.SharedOfficePlatform.domain.schedule.repository;

import com.FC.SharedOfficePlatform.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByMemberIdAndEventStartDateBetween(Long memberId, LocalDateTime eventStartDate, LocalDateTime eventEndDate);
}
