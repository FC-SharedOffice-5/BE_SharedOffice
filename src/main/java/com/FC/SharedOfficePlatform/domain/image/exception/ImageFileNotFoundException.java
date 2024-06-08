package com.FC.SharedOfficePlatform.domain.image.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class ImageFileNotFoundException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.IMAGE_FILE_NOT_FOUND;
    public ImageFileNotFoundException() {
        super(ErrorCode.IMAGE_FILE_NOT_FOUND);
    }
}
