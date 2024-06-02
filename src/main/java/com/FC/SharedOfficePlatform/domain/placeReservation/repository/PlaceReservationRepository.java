package com.FC.SharedOfficePlatform.domain.placeReservation.repository;

import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import com.FC.SharedOfficePlatform.domain.placeReservation.entity.PlaceReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceReservationRepository extends JpaRepository<PlaceReservation, Long> {
    List<PlaceReservation> findByPlace_Office_OfficeId(Long officeId);

    List<PlaceReservation> findByMemberId(Long memberId); // Member 엔티티의 memberId를 기준으로 조회
}
