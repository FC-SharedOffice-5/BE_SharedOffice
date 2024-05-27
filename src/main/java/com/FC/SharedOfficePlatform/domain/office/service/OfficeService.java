package com.FC.SharedOfficePlatform.domain.office.service;

import com.FC.SharedOfficePlatform.domain.office.dto.request.OfficeRequest;
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
    public List<OfficeListResponse> getAllOffice() {
        return officeRepository.findAll().stream()
                .map(office -> new OfficeListResponse(
                        office.getOfficeId(),
                        office.getOfficeName(),
                        office.getOfficeAddr(),
                        office.getOfficeFloor(),
                        office.getOfficeTime(),
                        office.getOfficeCapacity(),
                        office.getOfficeStudio(),
                        office.getOfficeMeeting(),
                        office.getOfficeLatitude(),
                        office.getOfficeLongitude(),
                        office.getCreatedAt(),
                        office.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OfficeResponse getDetailOffice(Long officeId) {
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> {
                    log.error("Office with ID {} not found", officeId); // 로그 추가
                    return new OfficeNotFoundException("Inquiry with ID " + officeId + " not found");
                });
        return OfficeResponse.from(office);
    }

}
