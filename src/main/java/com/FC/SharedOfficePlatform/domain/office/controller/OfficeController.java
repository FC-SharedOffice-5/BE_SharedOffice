package com.FC.SharedOfficePlatform.domain.office.controller;

import com.FC.SharedOfficePlatform.domain.office.dto.request.OfficeRequest;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeDetailResponse;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeListResponse;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeResponse;
import com.FC.SharedOfficePlatform.domain.office.exception.OfficeNotFoundException;
import com.FC.SharedOfficePlatform.domain.office.service.OfficeService;
import com.FC.SharedOfficePlatform.domain.place.exception.PlaceNotFoundException;
import com.FC.SharedOfficePlatform.global.security.CustomMemberDetails;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeService officeService;

    @PostMapping
    public ResponseEntity<OfficeResponse> insertOffice(@RequestBody OfficeRequest request) {
        OfficeResponse officeResponse = officeService.insertOffice(request);
        return new ResponseEntity<>(officeResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<OfficeListResponse>>> getAllOffice(Authentication authentication) {
        CustomMemberDetails userDetails = (CustomMemberDetails) authentication.getPrincipal();
        Long memberId = userDetails.getId();

        List<OfficeListResponse> officeListResponses = officeService.getAllOffice(memberId);
        return ResponseEntity.ok(ResponseDTO.okWithData(officeListResponses));
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO<List<OfficeListResponse>>> getAllAndSearchOffice(@RequestParam String officeName, Authentication authentication) {
        CustomMemberDetails userDetails = (CustomMemberDetails) authentication.getPrincipal();
        Long memberId = userDetails.getId();

        List<OfficeListResponse> officeListResponses = officeService.getAllAndSearchOffice(officeName, memberId);
        return ResponseEntity.ok(ResponseDTO.okWithData(officeListResponses));
    }

    @GetMapping("/{officeId}")
    public ResponseEntity<ResponseDTO<OfficeDetailResponse>> getDetailOffice(@PathVariable Long officeId, Authentication authentication) {
        CustomMemberDetails userDetails = (CustomMemberDetails) authentication.getPrincipal();
        Long memberId = userDetails.getId();

        OfficeDetailResponse officeDetailResponse = officeService.getDetailOffice(officeId, memberId);
        return ResponseEntity.ok(ResponseDTO.okWithData(officeDetailResponse));
    }
//    @GetMapping("/{officeId}")
//    public ResponseEntity<ResponseDTO<OfficeDetailResponse>> getDetailOffice(@PathVariable Long officeId, Authentication authentication) {
//        CustomMemberDetails userDetails = (CustomMemberDetails) authentication.getPrincipal();
//        Long memberId = userDetails.getId();
//
//        Optional<OfficeDetailResponse> officeDetailResponse = officeService.getDetailOffice(officeId, memberId);
//        if (officeDetailResponse.isPresent()) {
//            return ResponseEntity.ok(ResponseDTO.okWithData(officeDetailResponse.get()));
//        } else {
//            return new OfficeNotFoundException("Office with ID " + officeId + " not found");
//        }
//    }

}
