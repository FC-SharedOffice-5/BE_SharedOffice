package com.FC.SharedOfficePlatform.domain.comment.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class CommentNotFoundException extends ApplicationException {
    private static final ErrorCode ERROR_CODE = ErrorCode.COMMENT_NOT_FOUND;

    public CommentNotFoundException(String s) { super(ERROR_CODE); }
}
