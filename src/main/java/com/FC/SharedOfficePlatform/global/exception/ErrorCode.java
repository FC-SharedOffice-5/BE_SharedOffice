package com.FC.SharedOfficePlatform.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // USER
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),
    MEMBER_ALREADY_REGISTERED(HttpStatus.BAD_REQUEST, "이미 가입된 회원입니다."),
    REGISTERED_EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "등록된 메일이 존재하지 않습니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "패스워드가 틀렸습니다."),
    UNAUTHORIZED(HttpStatus.BAD_REQUEST, "허가되지 않은 시도입니다."),

    //INQUIRY
    INQUIRY_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 문의사항ID 입니다."),
    //BUSINESS
    BUSINESS_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 입점기업 입니다."),

    // 5xx
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 에러");

    private HttpStatus httpStatus;
    private String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}

