package com.FC.SharedOfficePlatform.domain.member.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class UnauthorizedException extends ApplicationException {

    public static final ErrorCode ERROR_CODE = ErrorCode.UNAUTHORIZED;

    public UnauthorizedException() {
        super(ErrorCode.UNAUTHORIZED);
    }

}
