package com.FC.SharedOfficePlatform.domain.image.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class FreeBoardNotFoundException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.FREE_BOARD_NOT_FOUND;

    public FreeBoardNotFoundException() {
        super(ErrorCode.FREE_BOARD_NOT_FOUND);
    }

}
