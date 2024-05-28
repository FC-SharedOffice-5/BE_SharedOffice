package com.FC.SharedOfficePlatform.domain.place.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class PlaceNotFoundException extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.PLACE_NOT_FOUND;

    public PlaceNotFoundException(String s) { super(ERROR_CODE); }
}
