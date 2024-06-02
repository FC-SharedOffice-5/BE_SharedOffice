package com.FC.SharedOfficePlatform.domain.business.controller;

import com.FC.SharedOfficePlatform.domain.business.dto.request.BusinessRequest;
import com.FC.SharedOfficePlatform.domain.business.dto.response.BusinessListResponse;
import com.FC.SharedOfficePlatform.domain.business.dto.response.BusinessResponse;
import com.FC.SharedOfficePlatform.domain.business.service.BusinessService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/businesses")
public class BusinessController {

    private final BusinessService businessService;

    @PostMapping
    public ResponseEntity<BusinessResponse> insertBusiness(@RequestBody BusinessRequest request) {
        BusinessResponse businessResponse = businessService.insertBusiness(request);
        return new ResponseEntity<>(businessResponse, HttpStatus.CREATED);
    }

    // 로그인한 memberId 문의만 조회가능 -> 추후 변경 가능성 있음
    @GetMapping
    public ResponseEntity<ResponseDTO<List<BusinessListResponse>>> getAllBusiness() {
        List<BusinessListResponse> businesses = businessService.getAllBusiness();
        return ResponseEntity.ok(ResponseDTO.okWithData(businesses));
    }

    @GetMapping("/{businessId}")
    public ResponseEntity<ResponseDTO<BusinessResponse>> getBusiness(@PathVariable Long businessId) {
        BusinessResponse businessResponse = businessService.getBusiness(businessId);
        return ResponseEntity.ok(ResponseDTO.okWithData(businessResponse));
    }

}
