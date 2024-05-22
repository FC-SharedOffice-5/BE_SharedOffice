package com.FC.SharedOfficePlatform.domain.inquiry.entity;

import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inquiry")
@NoArgsConstructor
@Getter
public class Inquiry extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inq_id", nullable = false)
    private Long inqId;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "inq_type", nullable = false)
    private int inqType;

    @Column(name = "inq_title", length = 50)
    private String inqTitle;

    @Column(name = "inq_contents", length = 500)
    private String inqContents;

    @Column(name = "inq_resp", nullable = false, columnDefinition = "TINYINT")
    private boolean inqResp;

    @Builder
    public Inquiry(long memberId, int inqType, String inqTitle,
                   String inqContents, boolean inqResp) {
        this.memberId = memberId;
        this.inqType = inqType;
        this.inqTitle = inqTitle;
        this.inqContents = inqContents;
        this.inqResp = inqResp;
    }

}
