package com.FC.SharedOfficePlatform.domain.office.controller;

import com.FC.SharedOfficePlatform.domain.office.dto.request.OfficeRequest;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeListResponse;
import com.FC.SharedOfficePlatform.domain.office.dto.response.OfficeResponse;
import com.FC.SharedOfficePlatform.domain.office.service.OfficeService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ResponseDTO<List<OfficeListResponse>>> getAllOffice() {
        List<OfficeListResponse> officeListResponses = officeService.getAllOffice();
        return ResponseEntity.ok(ResponseDTO.okWithData(officeListResponses));
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO<List<OfficeListResponse>>> getAllSearchOffice(@RequestParam String officeName) {
        List<OfficeListResponse> officeListResponses = officeService.getAllSearchOffice(officeName);
        return ResponseEntity.ok(ResponseDTO.okWithData(officeListResponses));
    }

    @GetMapping("/{officeId}")
    public ResponseEntity<ResponseDTO<OfficeResponse>> getDetailOffice(@PathVariable Long officeId) {
        OfficeResponse officeResponse = officeService.getDetailOffice(officeId);
        return ResponseEntity.ok(ResponseDTO.okWithData(officeResponse));
    }

}
