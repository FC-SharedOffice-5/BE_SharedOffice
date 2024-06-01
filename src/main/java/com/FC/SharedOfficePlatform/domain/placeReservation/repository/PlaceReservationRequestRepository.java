package com.FC.SharedOfficePlatform.domain.placeReservation.repository;

import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservation;
import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservationRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceReservationRequestRepository extends JpaRepository<PlaceReservationRequestEntity, Long> {
}
