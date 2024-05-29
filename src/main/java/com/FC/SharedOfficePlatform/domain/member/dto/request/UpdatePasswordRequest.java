package com.FC.SharedOfficePlatform.domain.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdatePasswordRequest(
    @NotNull(message = "비밀 번호를 입력해 주세요.")
    @Size(min = 8, message = "비밀 번호는 8자 이상 20자 이하입니다.")
    String password
) {

}
