package com.FC.SharedOfficePlatform.domain.placeReservation.repository;

import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservation;
import com.FC.SharedOfficePlatform.domain.seatReservation.entity.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceReservationRepository extends JpaRepository<PlaceReservation, Long> {
    List<PlaceReservation> findByPlace_Office_OfficeId(Long officeId);

    @Query("SELECT pr FROM PlaceReservation pr WHERE pr.place.officeId = :officeId AND pr.place.placeFloor = :placeFloor")
    List<PlaceReservation> findByPlaceFloorAndOfficeId(@Param("officeId") Long officeId, @Param("placeFloor") int placeFloor);

    List<PlaceReservation> findByMemberId(Long memberId);
}
