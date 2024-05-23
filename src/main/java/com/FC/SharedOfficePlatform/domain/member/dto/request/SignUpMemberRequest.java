package com.FC.SharedOfficePlatform.domain.member.dto.request;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.global.security.enums.Role;
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
    Role role,
    Boolean useYn,
    String memberName,
    String memberNickname,
    Boolean memberGender,
    LocalDate memberBirth,
    Boolean emailAgree,
    Boolean messageAgree,
    Boolean pushAgree
) {
    public String formattedMemberBirth() {
        if (memberBirth == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return memberBirth.format(formatter);
    }

    public Member toEntity(String encodedPassword) {
        return Member.builder()
            .email(email)
            .password(encodedPassword) // Note: Password should be encoded before saving
            .role(role)
            .useYn(useYn)
            .memberName(memberName)
            .memberNickname(memberNickname)
            .memberGender(memberGender)
            .memberBirth(memberBirth)
            .emailAgree(emailAgree)
            .messageAgree(messageAgree)
            .pushAgree(pushAgree)
            .build();
    }
}
