package com.FC.SharedOfficePlatform.domain.business.repository;

import com.FC.SharedOfficePlatform.domain.business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

}
