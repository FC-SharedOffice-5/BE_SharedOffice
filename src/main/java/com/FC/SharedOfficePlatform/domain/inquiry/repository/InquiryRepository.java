package com.FC.SharedOfficePlatform.domain.inquiry.repository;

import com.FC.SharedOfficePlatform.domain.inquiry.entity.Inquiry;
import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    List<Inquiry> findByMemberId(Long memberId);
}
