package com.FC.SharedOfficePlatform.domain.memberLike.controller;

import com.FC.SharedOfficePlatform.domain.memberLike.dto.request.MemberLikeRequest;
import com.FC.SharedOfficePlatform.domain.memberLike.dto.response.MemberLikeResponse;
import com.FC.SharedOfficePlatform.domain.memberLike.service.MemberLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memberLikes")
@Slf4j
public class MemberLikeController {

    private final MemberLikeService memberLikeService;

    @PostMapping
    public ResponseEntity<MemberLikeResponse> insertMemberLike(@RequestBody MemberLikeRequest request) {
        MemberLikeResponse memberLikeResponse = memberLikeService.insertMemberLike(request);
        return new ResponseEntity<>(memberLikeResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{likeId}")
    public ResponseEntity<MemberLikeResponse> deleteMemberLike(@PathVariable Long likeId) {
        MemberLikeResponse memberLikeResponse = memberLikeService.deleteMemberLike(likeId);
        return new ResponseEntity<>(memberLikeResponse, HttpStatus.OK);
    }



}
