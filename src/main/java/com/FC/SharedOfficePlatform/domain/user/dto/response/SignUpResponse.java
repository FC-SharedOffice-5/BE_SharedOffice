package com.FC.SharedOfficePlatform.domain.user.dto.response;

import com.FC.SharedOfficePlatform.domain.user.entity.User;

public record SignUpResponse(
    Long id,
    String email
) {
    public static SignUpResponse from(User user) {
        return new SignUpResponse(
            user.getId(),
            user.getEmail()
        );
    }
}
