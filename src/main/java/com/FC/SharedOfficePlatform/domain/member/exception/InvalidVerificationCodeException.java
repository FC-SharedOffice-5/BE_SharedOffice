package com.FC.SharedOfficePlatform.domain.member.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class InvalidVerificationCodeException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.INVALID_VERIFICATION_CODE;

    public InvalidVerificationCodeException() {
        super(ErrorCode.INVALID_VERIFICATION_CODE);
    }

}
