package com.FC.SharedOfficePlatform.domain.memberLike.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class MemberLikeNotFoundException extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.DOCUMENT_NOT_FOUND;

    public MemberLikeNotFoundException(String s) { super(ERROR_CODE); }
}
