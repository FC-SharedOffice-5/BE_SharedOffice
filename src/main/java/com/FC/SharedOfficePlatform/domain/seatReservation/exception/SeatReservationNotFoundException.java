package com.FC.SharedOfficePlatform.domain.seatReservation.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class SeatReservationNotFoundException extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.RESERVATION_NOT_FOUND;

    public SeatReservationNotFoundException(String s) { super(ERROR_CODE); }
}
