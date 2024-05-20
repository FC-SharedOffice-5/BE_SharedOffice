package com.FC.SharedOfficePlatform.domain.auth.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class InvalidPasswordException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.INVALID_PASSWORD;

    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }

}
