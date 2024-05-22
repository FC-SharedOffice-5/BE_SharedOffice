package com.FC.SharedOfficePlatform.domain.inquiry.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class InquiryNotFoundException extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.INQUIRY_NOT_FOUND;

    public InquiryNotFoundException(String s) { super(ERROR_CODE); }
}
