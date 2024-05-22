package com.FC.SharedOfficePlatform.domain.inquiry.controller;

import com.FC.SharedOfficePlatform.domain.inquiry.dto.request.InquiryRequest;
import com.FC.SharedOfficePlatform.domain.inquiry.dto.response.AllInquiryResponse;
import com.FC.SharedOfficePlatform.domain.inquiry.dto.response.InquiryResponse;
import com.FC.SharedOfficePlatform.domain.inquiry.service.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage/inquiries")
@Slf4j
public class InquiryController {

    private final InquiryService inquiryService;

    @PostMapping
    public ResponseEntity<InquiryResponse> insertInquiry(@RequestBody InquiryRequest request) {
        InquiryResponse inquiryResponse = inquiryService.insertInquiry(request);
        return new ResponseEntity<>(inquiryResponse, HttpStatus.CREATED);
    }

    // 로그인한 memberId 문의만 조회가능 -> 추후 변경 가능성 있음
    @GetMapping
    public ResponseEntity<List<AllInquiryResponse>> getAllInquiry(Long memberId) {
        List<AllInquiryResponse> inquiries = inquiryService.getAllInquiry(memberId);
        return ResponseEntity.ok(inquiries);
    }

    @GetMapping("/{inqId}")
    public ResponseEntity<InquiryResponse> getInquiry(@PathVariable Long inqId) {
        InquiryResponse inquiryResponse = inquiryService.getInquiry(inqId);
        return ResponseEntity.ok(inquiryResponse);
    }

}