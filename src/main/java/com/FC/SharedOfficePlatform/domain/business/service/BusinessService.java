package com.FC.SharedOfficePlatform.domain.business.service;

import com.FC.SharedOfficePlatform.domain.business.dto.request.BusinessRequest;
import com.FC.SharedOfficePlatform.domain.business.dto.response.BusinessListResponse;
import com.FC.SharedOfficePlatform.domain.business.dto.response.BusinessResponse;
import com.FC.SharedOfficePlatform.domain.business.entity.Business;
import com.FC.SharedOfficePlatform.domain.business.exception.BusinessNotFoundException;
import com.FC.SharedOfficePlatform.domain.business.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BusinessService {

    private final BusinessRepository businessRepository;

    @Transactional
    public BusinessResponse insertBusiness(BusinessRequest businessRequest) {
        Business business = businessRequest.toEntity();
        Business saveBusiness = businessRepository.save(business);
        return BusinessResponse.from(saveBusiness);
    }

    @Transactional(readOnly = true)
    public List<BusinessListResponse> getAllBusiness() {
        return businessRepository.findAll().stream()
                .map(business -> new BusinessListResponse(
                        business.getBusinessId(),
                        business.getBusinessName(),
                        business.getBusinessType(),
                        business.getBusinessNum(),
                        business.getBusinessContractStartDate(),
                        business.getBusinessContractEndDate(),
                        business.getBusinessCeo(),
                        business.getBusinessPhone(),
                        business.getBusinessContractPerson(),
                        business.getBusinessContractPhone(),
                        business.getCreatedAt(),
                        business.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BusinessResponse getBusiness(Long businessId) {
        Business business = businessRepository.findById(businessId)
                .orElseThrow(() -> {
                    log.error("Inquiry with ID {} not found", businessId); // 로그 추가
                    return new BusinessNotFoundException("Inquiry with ID " + businessId + " not found");
                });
        return BusinessResponse.from(business);
    }

}
