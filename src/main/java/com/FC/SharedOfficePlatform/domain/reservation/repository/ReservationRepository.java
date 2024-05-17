package com.FC.SharedOfficePlatform.domain.reservation.repository;

import com.FC.SharedOfficePlatform.domain.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
