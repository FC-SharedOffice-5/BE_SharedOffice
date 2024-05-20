package com.FC.SharedOfficePlatform.domain.member.entity;

import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import com.FC.SharedOfficePlatform.global.security.enums.AuthorityCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "member")
@NoArgsConstructor
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, length = 35)
    private String email;

    @Column(name = "password", length = 200)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "authCode", nullable = false)
    private AuthorityCode authCode;

    @Column(name = "useYN")
    private Boolean useYN;

    @Column(name = "memberName", length = 25)
    private String memberName;

    @Column(name = "memberNickname", length = 25)
    private String memberNickname;

    @Column(name = "memberGender")
    private Boolean memberGender;

    @Column(name = "memberBirth")
    private LocalDate memberBirth;

    // Boolean -> nullable
    @Column(name = "emailAgree")
    private Boolean emailAgree;

    @Column(name = "messageAgree")
    private Boolean messageAgree;

    @Column(name = "pushAgree")
    private Boolean pushAgree;

    @Column(name = "modifiedId", length = 35)
    private String modifiedId;

    @PrePersist
    public void prePersist() {
        // Set default authCode to ROLE_MEMBER if not already set
        if (this.authCode == null) {
            this.authCode = AuthorityCode.ROLE_MEMBER;
        }
    }

    @Builder
    public Member(String email, String password, String memberName, String memberNickname,
        Boolean memberGender, LocalDate memberBirth, Boolean emailAgree,
        Boolean messageAgree, Boolean pushAgree, AuthorityCode authCode) {
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.memberNickname = memberNickname;
        this.memberGender = memberGender;
        this.memberBirth = memberBirth;
        this.emailAgree = emailAgree;
        this.messageAgree = messageAgree;
        this.pushAgree = pushAgree;
        this.authCode = authCode;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
