package com.FC.SharedOfficePlatform.domain.office.service;

import com.FC.SharedOfficePlatform.domain.document.dto.response.DocumentListResponse;
import com.FC.SharedOfficePlatform.domain.office.dto.request.OfficeRequest;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeDetailResponse;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeListResponse;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeResponse;
import com.FC.SharedOfficePlatform.domain.office.entity.Office;
import com.FC.SharedOfficePlatform.domain.office.exception.OfficeNotFoundException;
import com.FC.SharedOfficePlatform.domain.office.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Transactional
    public OfficeResponse insertOffice(OfficeRequest officeRequest) {
        Office office = officeRequest.toEntity();
        Office saveOffice = officeRepository.save(office);
        return OfficeResponse.from(saveOffice);
    }

    @Transactional(readOnly = true)
    public List<OfficeListResponse> getAllOffice(Long memberId) {
        List<OfficeListResponse> officeListResponses = officeRepository.findAllWithLikesCount(memberId);
        for (OfficeListResponse response : officeListResponses) {
            Office office = officeRepository.findById(response.getOfficeId()).orElseThrow(() -> new OfficeNotFoundException("Office not found"));
            response.setOfficeFacilities(office.getOfficeFacilities());
        }
        return officeListResponses;
    }

    @Transactional(readOnly = true)
    public List<OfficeListResponse> getAllAndSearchOffice(String officeName, Long memberId) {
        List<OfficeListResponse> officeListResponses;
        if (officeName == null || officeName.isEmpty()) {
            officeListResponses = officeRepository.findAllWithLikesCount(memberId);
        } else {
            officeListResponses = officeRepository.findAllWithLikesCountAndName(officeName, memberId);
        }

        for (OfficeListResponse response : officeListResponses) {
            Office office = officeRepository.findById(response.getOfficeId())
                    .orElseThrow(() -> new OfficeNotFoundException("Office not found"));
            response.setOfficeFacilities(office.getOfficeFacilities());
        }

        return officeListResponses;
    }

    @Transactional(readOnly = true)
    public OfficeDetailResponse getDetailOffice(Long officeId, Long memberId) {
        OfficeDetailResponse officeDetailResponse = officeRepository.findByOfficeIdWithLikesCount(officeId, memberId)
                .orElseThrow(() -> new OfficeNotFoundException("Office with ID " + officeId + " not found"));

        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new OfficeNotFoundException("Office with ID " + officeId + " not found"));

        officeDetailResponse.setOfficeFacilities(office.getOfficeFacilities());

        return officeDetailResponse;
    }

}
