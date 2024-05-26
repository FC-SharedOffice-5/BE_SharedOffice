package com.FC.SharedOfficePlatform.domain.member.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class EmailSendingException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.EMAIL_SENDING_EXCEPTION;

    public EmailSendingException() {
        super(ErrorCode.EMAIL_SENDING_EXCEPTION);
    }

}
