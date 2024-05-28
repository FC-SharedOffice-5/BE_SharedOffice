package com.FC.SharedOfficePlatform.domain.document.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class DocumentNotFoundException extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.DOCUMENT_NOT_FOUND;

    public DocumentNotFoundException(String s) { super(ERROR_CODE); }
}
