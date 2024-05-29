package com.FC.SharedOfficePlatform.domain.member.entity;

import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import com.FC.SharedOfficePlatform.global.security.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
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
    private Role role;

    @Column(name = "department")
    private String department;

    @Column(name = "use_yn", columnDefinition = "TINYINT(1)")
    private Boolean useYn;

    @Column(name = "member_name", length = 25)
    private String memberName;

    @Column(name = "member_nickname", length = 25)
    private String memberNickname;

    @Column(name = "member_gender", columnDefinition = "TINYINT(1)")
    private Boolean memberGender;

    @Column(name = "member_birth")
    private LocalDate memberBirth;

    @Column(name = "email_agree", columnDefinition = "TINYINT(1)")
    private Boolean emailAgree;

    @Column(name = "message_agree", columnDefinition = "TINYINT(1)")
    private Boolean messageAgree;

    @Column(name = "push_agree", columnDefinition = "TINYINT(1)")
    private Boolean pushAgree;

    @Builder
    public Member(String email, String password, Role role, String department, Boolean useYn,
        String memberName, String memberNickname, Boolean memberGender, LocalDate memberBirth,
        Boolean emailAgree, Boolean messageAgree, Boolean pushAgree) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.useYn = useYn;
        this.memberName = memberName;
        this.memberNickname = memberNickname;
        this.memberGender = memberGender;
        this.memberBirth = memberBirth;
        this.emailAgree = emailAgree;
        this.messageAgree = messageAgree;
        this.pushAgree = pushAgree;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
}
