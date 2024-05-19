package com.FC.SharedOfficePlatform.domain.member.dto.request;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.global.security.enums.AuthorityCode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record SignUpMemberRequest(
    @NotNull(message = "이메일을 입력해 주세요.")
    @Email(message = "이메일 형식이 유효하지 않습니다.")
    String email,
    @NotNull(message = "비밀 번호를 입력해 주세요.")
    @Size(min = 8, message = "비밀 번호는 8자 이상 20자 이하입니다.")
    String password,
    @NotNull(message = "사용자 이름을 입력해 주세요.")
    String memberName,
    String memberNickname,
    String memberGender,
    LocalDate memberBirth,

    // Boolean Object type can be null, this for nullable field : Optional
    Boolean emailAgree,
    Boolean messageAgree,
    Boolean pushAgree,
    AuthorityCode authCode
) {
    public String formattedMemberBirth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        return memberBirth.format(formatter);
    }
    public Member toEntity(String encodedPassword) {
        return Member
            .builder()
            .email(email)
            .password(password)
            .memberName(memberName)
            .memberNickname(memberNickname)
            .memberBirth(memberBirth)
            .emailAgree(emailAgree)
            .messageAgree(messageAgree)
            .pushAgree( pushAgree) // Default to agree (0 : false : agree on this application)
            .authCode(AuthorityCode.ROLE_MEMBER) // Default auth code
            .build()
            ;
    }
}
