package com.FC.SharedOfficePlatform.domain.auth.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class MemberNotFoundException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.MEMBER_NOT_FOUND;

    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }

}
