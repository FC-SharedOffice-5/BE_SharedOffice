package com.FC.SharedOfficePlatform.domain.comment.entity;

import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@NoArgsConstructor
@Getter
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long commentId;

    @Column(name = "member_id", nullable = false)
    private long memberId;

    @Column(name = "link_id", nullable = false)
    private long linkId;

    @Column(name = "link_category", nullable = false)
    private int linkCategory;

    @Column(name = "comment_write", length = 100)
    private String commentWrite;


    @Builder
    public Comment(
            long memberId,
            long linkId,
            int linkCategory,
            String commentWrite
    ) {
        this.memberId = memberId;
        this.linkId = linkId;
        this.linkCategory = linkCategory;
        this.commentWrite = commentWrite;
    }

}
