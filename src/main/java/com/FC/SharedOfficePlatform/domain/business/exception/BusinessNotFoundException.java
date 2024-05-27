package com.FC.SharedOfficePlatform.domain.business.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class BusinessNotFoundException extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.BUSINESS_NOT_FOUND;

    public BusinessNotFoundException(String s) { super(ERROR_CODE); }
}
