package com.FC.SharedOfficePlatform.domain.document.repository;

import com.FC.SharedOfficePlatform.domain.document.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByMemberId(Long memberId);
}
