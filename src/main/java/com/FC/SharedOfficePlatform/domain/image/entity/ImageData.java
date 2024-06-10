package com.FC.SharedOfficePlatform.domain.image.entity;

import com.FC.SharedOfficePlatform.domain.freeBoard.entity.FreeBoard;
import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ImageData")
@NoArgsConstructor
@Getter
public class ImageData extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    // to prevent uploading duplicated image files.
    private String hash;

    @Lob
    @Column(name = "image_data", columnDefinition = "MEDIUMBLOB")
    private byte[] imageData;

    // New field for storing the URL
    private String url;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private FreeBoard freeBoard;

    @Builder
    public ImageData(String name, String type, String hash, byte[] imageData, String url, Member member, FreeBoard freeBoard) {
        this.name = name;
        this.type = type;
        this.hash = hash;
        this.imageData = imageData;
        this.url = url;
        this.member = member;
        this.freeBoard = freeBoard;
    }
}
