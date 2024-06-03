package com.FC.SharedOfficePlatform.domain.qrcode.controller;

import com.FC.SharedOfficePlatform.domain.qrcode.dto.QRRequest;
import com.FC.SharedOfficePlatform.domain.qrcode.service.QRService;
import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qrcode")
public class QRController {

    private final QRService qrService;

    @PostMapping("/validate")
    public ResponseEntity<ResponseDTO<Void>> validateQR(
        @RequestBody @Valid QRRequest request
    ) {
        qrService.ValidateQR(request);
        return ResponseEntity.ok(ResponseDTO.ok());
    }

}
