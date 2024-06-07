package com.FC.SharedOfficePlatform.domain.image.exception;

import com.FC.SharedOfficePlatform.global.exception.ApplicationException;
import com.FC.SharedOfficePlatform.global.exception.ErrorCode;

public class ImageFileAlreadyRegisteredException extends ApplicationException {

    private static final ErrorCode ERROR_CODE = ErrorCode.IMAGE_FILE_ALREADY_REGISTERED;
    public ImageFileAlreadyRegisteredException() {
        super(ErrorCode.IMAGE_FILE_ALREADY_REGISTERED);
    }

}
