package com.FC.SharedOfficePlatform.domain.office.repository;

import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeDetailResponse;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeListResponse;
import com.FC.SharedOfficePlatform.domain.office.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    @Query("SELECT new com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeListResponse(" +
            "o.officeId, o.officeName, o.officeTime, o.officeCapacity, o.officeStudio, " +
            "o.officeMeeting, o.officeLatitude, o.officeLongitude, o.officeFacilities," +
            "MAX(CASE WHEN ml.memberId = :memberId THEN 1 ELSE 0 END) = 1, " +
            "o.createdAt, o.updatedAt) " +
            "FROM Office o " +
            "LEFT JOIN MemberLike ml ON ml.linkCode = o.officeId AND ml.linkCategory = 0 " +
            "GROUP BY o.officeId")
    List<OfficeListResponse> findAllWithLikesCount(Long memberId);

    @Query("SELECT new com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeListResponse(" +
            "o.officeId, o.officeName, o.officeTime, o.officeCapacity, o.officeStudio, " +
            "o.officeMeeting, o.officeLatitude, o.officeLongitude, o.officeFacilities, " +
            "MAX(CASE WHEN ml.memberId = :memberId THEN 1 ELSE 0 END) = 1, " +
            "o.createdAt, o.updatedAt) " +
            "FROM Office o " +
            "LEFT JOIN MemberLike ml ON ml.linkCode = o.officeId AND ml.linkCategory = 0 " +
            "WHERE o.officeName LIKE %:officeName% " +
            "GROUP BY o.officeId")
    List<OfficeListResponse> findAllWithLikesCountAndName(String officeName, Long memberId);

    @Query("SELECT new com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeDetailResponse(" +
            "o.officeId, o.officeName, o.officeAddr, o.officeFloor, o.officeTime, o.officeCapacity, " +
            "o.officeStudio, o.officeMeeting, o.officeLatitude, o.officeLongitude, o.officeFacilities, o.officePhone, " +
            "MAX(CASE WHEN ml.memberId = :memberId THEN 1 ELSE 0 END) = 1) " +
            "FROM Office o " +
            "LEFT JOIN MemberLike ml ON ml.linkCode = o.officeId AND ml.linkCategory = 0 " +
            "WHERE o.officeId = :officeId " +
            "GROUP BY o.officeId")
    Optional<OfficeDetailResponse> findByOfficeIdWithLikesCount(Long officeId, Long memberId);
}
