package com.FC.SharedOfficePlatform.domain.attendees.repository;

import com.FC.SharedOfficePlatform.domain.attendees.entity.Attendees;
import com.FC.SharedOfficePlatform.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendeesRepository extends JpaRepository<Attendees, Long> {
    List<Attendees> findBySchedule(Schedule schedule);
}
