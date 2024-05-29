package com.FC.SharedOfficePlatform.domain.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record SendEmailRequest(
    @NotNull(message = "이메일을 입력해 주세요.")
    @Email(message = "이메일 형식이 유효하지 않습니다.")
    String email
) {

}
