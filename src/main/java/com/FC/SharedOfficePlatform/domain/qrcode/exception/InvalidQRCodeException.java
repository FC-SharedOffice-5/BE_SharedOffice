package com.FC.SharedOfficePlatform.domain.qrcode.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class InvalidQRCodeException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.INVALID_QRCODE;

    public InvalidQRCodeException() {
        super(ErrorCode.INVALID_QRCODE);
    }

}
