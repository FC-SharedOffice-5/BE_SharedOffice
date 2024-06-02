package com.FC.SharedOfficePlatform.domain.seatReservation.repository;

import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservation;
import com.FC.SharedOfficePlatform.domain.seatReservation.entity.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {
    @Query("SELECT sr FROM SeatReservation sr JOIN sr.seat s WHERE s.seatFloor = :seatFloor AND s.officeId = :officeId")
    List<SeatReservation> findBySeatFloorAndOfficeId(@Param("officeId") Long officeId, @Param("seatFloor") int seatFloor);

    List<SeatReservation> findByMemberId(Long memberId);
}

