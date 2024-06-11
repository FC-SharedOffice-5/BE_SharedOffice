package com.FC.SharedOfficePlatform.domain.community.service;

import com.FC.SharedOfficePlatform.domain.comment.repository.CommentRepository;
import com.FC.SharedOfficePlatform.domain.community.dto.response.CommunityListResponse;
import com.FC.SharedOfficePlatform.domain.community.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunityService {

    private final CommunityRepository communityRepository;

    @Transactional(readOnly = true)
    public List<CommunityListResponse> getAllCommunity(String boardTitle) {
        return communityRepository.findAllWithLikesCountAndName(boardTitle);
    }
}
