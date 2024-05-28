package com.FC.SharedOfficePlatform.domain.document.entity;

import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "document")
@NoArgsConstructor
@Getter
public class Document extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id", nullable = false)
    private Long docId;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "doc_category", nullable = false)
    private int docCategory;

    @Column(name = "doc_office_id", nullable = false)
    private int docOfficeId;

    @Column(name = "doc_title", length = 50)
    private String docTitle;

    @Column(name = "doc_contents", length = 500)
    private String docContents;


    @Builder
    public Document(
            long memberId,
            int docCategory,
            int docOfficeId,
            String docTitle,
            String docContents
    ) {
        this.memberId = memberId;
        this.docCategory = docCategory;
        this.docOfficeId = docOfficeId;
        this.docTitle = docTitle;
        this.docContents = docContents;
    }

}
