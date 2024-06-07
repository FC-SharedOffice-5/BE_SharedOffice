package com.FC.SharedOfficePlatform.domain.memberLike.repository;

import com.FC.SharedOfficePlatform.domain.memberLike.entity.MemberLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberLikeRepository extends JpaRepository<MemberLike, Long> {
    List<MemberLike> findByMemberId(Long memberId);
}
