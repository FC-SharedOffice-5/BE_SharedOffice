package com.FC.SharedOfficePlatform.domain.seat.repository;

import com.FC.SharedOfficePlatform.domain.seat.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByOfficeId(@Param("officeId") Long officeId);
}

