package com.FC.SharedOfficePlatform.domain.memberLike.service;

import com.FC.SharedOfficePlatform.domain.memberLike.dto.request.MemberLikeRequest;
import com.FC.SharedOfficePlatform.domain.memberLike.dto.response.MemberLikeResponse;
import com.FC.SharedOfficePlatform.domain.memberLike.entity.MemberLike;
import com.FC.SharedOfficePlatform.domain.memberLike.repository.MemberLikeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberLikeService {

    private final MemberLikeRepository memberLikeRepository;

    @Transactional
    public MemberLikeResponse insertMemberLike(MemberLikeRequest request) {
        MemberLike memberLike = request.toEntity();
        MemberLike savedMemberLike = memberLikeRepository.save(memberLike);
        return MemberLikeResponse.from(savedMemberLike);
    }

    public MemberLikeResponse deleteMemberLike(Long likeId) {
        MemberLike memberLike = memberLikeRepository.findById(likeId)
                .orElseThrow(() -> new EntityNotFoundException("MemberLike with ID " + likeId + " not found"));

        // MemberLike 삭제
        memberLikeRepository.deleteById(likeId);

        return MemberLikeResponse.from(memberLike);
    }

}
