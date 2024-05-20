package com.FC.SharedOfficePlatform.domain.member.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class MemberAlreadyRegisteredException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.MEMBER_ALREADY_REGISTERED;

    public MemberAlreadyRegisteredException() {
        super(ErrorCode.MEMBER_ALREADY_REGISTERED);
    }

}
