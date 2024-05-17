package com.FC.SharedOfficePlatform.domain.member.repository;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
