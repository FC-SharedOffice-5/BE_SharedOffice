package com.FC.SharedOfficePlatform.global.util;

import com.FC.SharedOfficePlatform.global.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseDTO<T> {

    private final int code;
    private final String errorMessage;
    private final T data;

    @Builder
    private ResponseDTO(int code, String errorMessage, T data) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public static ResponseDTO<Void> ok() {
        return ResponseDTO.<Void>builder()
            .code(HttpStatus.OK.value())
            .data(null)
            .errorMessage(null)
            .build();
    }

    public static <T> ResponseDTO<T> okWithData(T data) {
        return ResponseDTO.<T>builder()
            .code(HttpStatus.OK.value())
            .data(data)
            .errorMessage(null)
            .build();
    }

    public static ResponseDTO<Void> error(ErrorCode errorCode) {
        return ResponseDTO.<Void>builder()
            .code(errorCode.getHttpStatus().value())
            .errorMessage(errorCode.getMessage())
            .data(null)
            .build();
    }

    public static ResponseDTO<Void> errorWithMessage(HttpStatus httpStatus, String errorMessage) {
        return ResponseDTO.<Void>builder()
            .code(httpStatus.value())
            .errorMessage(errorMessage)
            .data(null)
            .build();
    }
}
