package com.FC.SharedOfficePlatform.domain.place.repository;

import com.FC.SharedOfficePlatform.domain.place.dto.PlaceFloorStats;
import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("SELECT new com.FC.SharedOfficePlatform.domain.place.dto.PlaceFloorStats(p.placeFloor, " +
            "SUM(CASE WHEN p.placeCategory = 0 THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN p.placeCategory = 1 THEN 1 ELSE 0 END)) " +
            "FROM Place p " +
            "WHERE p.officeId = :officeId AND p.placeCategory IN (0, 1) " +
            "GROUP BY p.placeFloor")
    List<PlaceFloorStats> findPlaceFloorStatistics(@Param("officeId") long officeId);
//    List<Place> findGroupedByPlaceFloor(@Param("officeId") long officeId);
}

