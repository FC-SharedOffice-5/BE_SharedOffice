package com.FC.SharedOfficePlatform.domain.inquiry.service;

import com.FC.SharedOfficePlatform.domain.inquiry.dto.request.InquiryRequest;
import com.FC.SharedOfficePlatform.domain.inquiry.dto.response.InquiryListResponse;
import com.FC.SharedOfficePlatform.domain.inquiry.dto.response.InquiryResponse;
import com.FC.SharedOfficePlatform.domain.inquiry.entity.Inquiry;
import com.FC.SharedOfficePlatform.domain.inquiry.exception.InquiryNotFoundException;
import com.FC.SharedOfficePlatform.domain.inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    @Transactional
    public InquiryResponse insertInquiry(InquiryRequest request) {
        Inquiry inquiry = request.toEntity();
        Inquiry savedInquiry = inquiryRepository.save(inquiry);
        return InquiryResponse.from(savedInquiry);
    }

    @Transactional(readOnly = true)
    public List<InquiryListResponse> getAllInquiry(Long memberId) {
        return inquiryRepository.findByMemberId(memberId).stream()
                .map(inquiry -> new InquiryListResponse(
                        inquiry.getInqId(),
                        inquiry.getMemberId(),
                        inquiry.getInqType(),
                        inquiry.getInqTitle(),
                        inquiry.isInqResp(),
                        inquiry.getCreatedAt(),
                        inquiry.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public InquiryResponse getInquiry(Long inqId) {
        Inquiry inquiry = inquiryRepository.findById(inqId)
                .orElseThrow(() -> {
                    log.error("Inquiry with ID {} not found", inqId); // 로그 추가
                    return new InquiryNotFoundException("Inquiry with ID " + inqId + " not found");
                });
        return InquiryResponse.from(inquiry);
    }

}
