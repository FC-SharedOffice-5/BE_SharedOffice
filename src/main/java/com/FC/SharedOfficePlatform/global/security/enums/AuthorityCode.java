package com.FC.SharedOfficePlatform.global.security.enums;

public enum AuthorityCode {
    ROLE_SUPER_ADMIN(0),
    ROLE_OFFICE_ADMIN(1),
    ROLE_MEMBER(2);

    private final int authCode;

    AuthorityCode(int authCode) {
        this.authCode = authCode;
    }

    public int getAuthCode() {
        return authCode;
    }
}
