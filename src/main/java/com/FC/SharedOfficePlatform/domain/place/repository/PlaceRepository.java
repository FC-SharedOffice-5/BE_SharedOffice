package com.FC.SharedOfficePlatform.domain.place.repository;

import com.FC.SharedOfficePlatform.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

}