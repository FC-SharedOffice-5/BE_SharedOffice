package com.FC.SharedOfficePlatform.domain.user.dto.request;

import com.FC.SharedOfficePlatform.domain.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SignUpRequest(

    @Email(message = "email의 형식이 틀렸습니다.")
    @NotNull(message = "email은 필수로 입력하셔야 합니다.")
    String email,

    @Size(min = 8, message = "영문, 숫자, 특수문자를 조합해서 입력해주세요. (8~20자)")
    String password
) {
    public User toEntity(String password) {
        return User.builder()
            .email(email)
            .encryptedPassword(password)
            .build();
    }

}
