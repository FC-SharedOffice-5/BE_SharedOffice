package com.FC.SharedOfficePlatform.domain.document.service;

import com.FC.SharedOfficePlatform.domain.document.dto.request.DocumentRequest;
import com.FC.SharedOfficePlatform.domain.document.dto.response.DocumentListResponse;
import com.FC.SharedOfficePlatform.domain.document.dto.response.DocumentResponse;
import com.FC.SharedOfficePlatform.domain.document.entity.Document;
import com.FC.SharedOfficePlatform.domain.document.exception.DocumentNotFoundException;
import com.FC.SharedOfficePlatform.domain.document.repository.DocumentRepository;
import com.FC.SharedOfficePlatform.domain.place.dto.response.PlaceListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentService {

    private final DocumentRepository documentRepository;

    @Transactional
    public DocumentResponse insertDocument(DocumentRequest request) {
        Document document = request.toEntity();
        Document savedDocument = documentRepository.save(document);
        return DocumentResponse.from(savedDocument);
    }

    @Transactional(readOnly = true)
    public List<DocumentListResponse> getAllDocument() {
        return documentRepository.findAll().stream()
                .map(DocumentListResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DocumentResponse getDocument(Long docId) {
        Document document = documentRepository.findById(docId)
                .orElseThrow(() -> {
                    log.error("Document with ID {} not found", docId); // 로그 추가
                    return new DocumentNotFoundException("Document with ID " + docId + " not found");
                });
        return DocumentResponse.from(document);
    }

}
