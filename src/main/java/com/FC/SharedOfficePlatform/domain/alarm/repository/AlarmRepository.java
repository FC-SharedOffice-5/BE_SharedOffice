package com.FC.SharedOfficePlatform.domain.alarm.repository;

import com.FC.SharedOfficePlatform.domain.alarm.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> {

}
