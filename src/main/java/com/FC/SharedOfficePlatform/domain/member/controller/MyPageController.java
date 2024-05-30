package com.FC.SharedOfficePlatform.domain.member.controller;

import com.FC.SharedOfficePlatform.domain.member.dto.request.UpdateMyInfoRequest;
import com.FC.SharedOfficePlatform.domain.member.dto.response.MyInfoResponse;
import com.FC.SharedOfficePlatform.domain.member.dto.response.UpdateMyInfoResponse;
import com.FC.SharedOfficePlatform.domain.member.service.MyPageService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PatchMapping("/update/info/{memberId}")
    public ResponseEntity<ResponseDTO<UpdateMyInfoResponse>> updateMyInfo(
        @PathVariable Long memberId, @RequestBody @Valid UpdateMyInfoRequest request
    ) {
        UpdateMyInfoResponse response = myPageService.updateMyInfo(memberId, request);
        return ResponseEntity.ok(ResponseDTO.okWithData(response));
    }
}
