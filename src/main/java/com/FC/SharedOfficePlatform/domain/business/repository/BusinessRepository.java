package com.FC.SharedOfficePlatform.domain.business.repository;

import com.FC.SharedOfficePlatform.domain.business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
//    List<Business> findByMemberId(Long memberId);
}
