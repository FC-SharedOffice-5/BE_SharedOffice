package com.FC.SharedOfficePlatform.domain.office.repository;

import com.FC.SharedOfficePlatform.domain.office.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
    List<Office> findByOfficeNameContaining(String officeName);
}
