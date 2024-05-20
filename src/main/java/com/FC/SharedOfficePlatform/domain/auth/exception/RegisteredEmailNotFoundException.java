package com.FC.SharedOfficePlatform.domain.auth.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class RegisteredEmailNotFoundException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.REGISTERED_EMAIL_NOT_FOUND;
    public RegisteredEmailNotFoundException() { super(ErrorCode.REGISTERED_EMAIL_NOT_FOUND);}

}
