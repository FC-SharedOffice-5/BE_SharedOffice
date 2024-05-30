package com.FC.SharedOfficePlatform.domain.schedule.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class ScheduleNotFoundException extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.SCHEDULE_NOT_FOUND;

    public ScheduleNotFoundException(String s) { super(ERROR_CODE); }
}
