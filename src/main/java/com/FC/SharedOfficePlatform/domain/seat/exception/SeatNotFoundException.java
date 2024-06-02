package com.FC.SharedOfficePlatform.domain.seat.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class SeatNotFoundException extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.SEAT_NOT_FOUND;

    public SeatNotFoundException(String s) { super(ERROR_CODE); }
}
