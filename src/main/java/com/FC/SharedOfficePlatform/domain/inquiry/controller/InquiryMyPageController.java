package com.FC.SharedOfficePlatform.domain.inquiry.controller;

import com.FC.SharedOfficePlatform.domain.inquiry.dto.request.InquiryRequest;
import com.FC.SharedOfficePlatform.domain.inquiry.dto.response.InquiryListResponse;
import com.FC.SharedOfficePlatform.domain.inquiry.dto.response.InquiryResponse;
import com.FC.SharedOfficePlatform.domain.inquiry.service.InquiryService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage/inquiries")
@Slf4j
public class InquiryMyPageController {

    private final InquiryService inquiryService;

    @PostMapping
    public ResponseEntity<InquiryResponse> insertInquiry(@RequestBody InquiryRequest request) {
        InquiryResponse inquiryResponse = inquiryService.insertInquiry(request);
        return new ResponseEntity<>(inquiryResponse, HttpStatus.CREATED);
    }

    // 로그인한 memberId 문의만 조회가능 -> 추후 변경 가능성 있음
    @GetMapping
    public ResponseEntity<ResponseDTO<List<InquiryListResponse>>> getAllInquiry(Long memberId) {
        List<InquiryListResponse> inquiryListResponse = inquiryService.getAllInquiry(memberId);
        return ResponseEntity.ok(ResponseDTO.okWithData(inquiryListResponse));
    }

    @GetMapping("/{inqId}")
    public ResponseEntity<ResponseDTO<InquiryResponse>> getInquiry(@PathVariable Long inqId) {
        InquiryResponse inquiryResponse = inquiryService.getInquiry(inqId);
        return ResponseEntity.ok(ResponseDTO.okWithData(inquiryResponse));
    }

}
