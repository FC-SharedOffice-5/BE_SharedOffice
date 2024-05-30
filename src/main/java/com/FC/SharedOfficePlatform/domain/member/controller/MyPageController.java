package com.FC.SharedOfficePlatform.domain.member.controller;

import com.FC.SharedOfficePlatform.domain.member.dto.response.MyInfoResponse;
import com.FC.SharedOfficePlatform.domain.member.service.MyPageService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/info/{memberId}")
    public ResponseEntity<ResponseDTO<MyInfoResponse>> getMyInfo(
        @PathVariable Long memberId
    ) {
        MyInfoResponse response = myPageService.getMyInfo(memberId);
        return ResponseEntity.ok(ResponseDTO.okWithData(response));
    }
}
