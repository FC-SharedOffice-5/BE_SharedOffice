package com.FC.SharedOfficePlatform.domain.document.controller;

import com.FC.SharedOfficePlatform.domain.document.dto.request.DocumentRequest;
import com.FC.SharedOfficePlatform.domain.document.dto.response.DocumentListResponse;
import com.FC.SharedOfficePlatform.domain.document.dto.response.DocumentResponse;
import com.FC.SharedOfficePlatform.domain.document.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notices")
@Slf4j
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity<DocumentResponse> insertDocument(@RequestBody DocumentRequest request) {
        DocumentResponse documentResponse = documentService.insertDocument(request);
        return new ResponseEntity<>(documentResponse, HttpStatus.CREATED);
    }

    // 로그인한 memberId 문의만 조회가능 -> 추후 변경 가능성 있음
    @GetMapping
    public ResponseEntity<List<DocumentListResponse>> getAllDocument() {
        List<DocumentListResponse> documentListResponse = documentService.getAllDocument();
        return ResponseEntity.ok(documentListResponse);
    }

    @GetMapping("/{docId}")
    public ResponseEntity<DocumentResponse> getDocument(@PathVariable Long docId) {
        DocumentResponse documentResponse = documentService.getDocument(docId);
        return ResponseEntity.ok(documentResponse);
    }

}
