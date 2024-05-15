package com.FC.SharedOfficePlatform.domain.user.exception;

import global.exception.ApplicationException;
import global.exception.ErrorCode;

public class UserAlreadyRegisteredException extends ApplicationException {

    public UserAlreadyRegisteredException() {
        super(ErrorCode.USER_ALREADY_REGISTERED);
    }

}
