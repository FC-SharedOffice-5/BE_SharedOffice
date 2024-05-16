package com.FC.SharedOfficePlatform.domain.member.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class MemberAlreadyRegisteredException extends ApplicationException {

    public MemberAlreadyRegisteredException() {
        super(ErrorCode.MEMBER_ALREADY_REGISTERED);
    }

}
