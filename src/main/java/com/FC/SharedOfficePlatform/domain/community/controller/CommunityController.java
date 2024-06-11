package com.FC.SharedOfficePlatform.domain.community.controller;

import com.FC.SharedOfficePlatform.domain.community.dto.response.CommunityListResponse;
import com.FC.SharedOfficePlatform.domain.community.service.CommunityService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/community")
@Slf4j
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO<List<CommunityListResponse>>> getAllCommunity(@RequestParam String boardTitle) {
        List<CommunityListResponse> communityListResponse = communityService.getAllCommunity(boardTitle);
        return ResponseEntity.ok(ResponseDTO.okWithData(communityListResponse));
    }
}
