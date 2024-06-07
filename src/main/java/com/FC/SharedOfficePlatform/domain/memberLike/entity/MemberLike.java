package com.FC.SharedOfficePlatform.domain.memberLike.entity;

import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member_like")
@NoArgsConstructor
@Getter
public class MemberLike extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id", nullable = false)
    private Long likeId;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "link_code", nullable = false)
    private long linkCode;

    @Column(name = "link_category", nullable = false)
    private int linkCategory;


    @Builder
    public MemberLike(
            long memberId,
            long linkCode,
            int linkCategory
    ) {
        this.memberId = memberId;
        this.linkCode = linkCode;
        this.linkCategory = linkCategory;
    }

}
