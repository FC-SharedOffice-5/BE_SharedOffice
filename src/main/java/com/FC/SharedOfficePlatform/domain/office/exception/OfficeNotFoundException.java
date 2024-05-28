package com.FC.SharedOfficePlatform.domain.office.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class OfficeNotFoundException extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.OFFICE_NOT_FOUND;

    public OfficeNotFoundException(String s) { super(ERROR_CODE); }
}
