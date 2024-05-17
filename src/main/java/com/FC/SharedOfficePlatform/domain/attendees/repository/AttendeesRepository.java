package com.FC.SharedOfficePlatform.domain.attendees.repository;

import com.FC.SharedOfficePlatform.domain.attendees.entity.Attendees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeesRepository extends JpaRepository<Attendees, Long> {

}
