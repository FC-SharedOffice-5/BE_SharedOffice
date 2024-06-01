package com.FC.SharedOfficePlatform.domain.placeReservation.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class PlaceReservationNotFoundException  extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.RESERVATION_NOT_FOUND;

    public PlaceReservationNotFoundException(String s) { super(ERROR_CODE); }
}
