package com.FC.SharedOfficePlatform.domain.member.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class AlreadyUsedPasswordException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.ALREADY_USED_PASSWORD;

    public AlreadyUsedPasswordException() {
        super(ErrorCode.ALREADY_USED_PASSWORD);
    }
}
