package com.FC.SharedOfficePlatform.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // MEMBER
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),
    MEMBER_ALREADY_REGISTERED(HttpStatus.BAD_REQUEST, "이미 가입된 회원입니다."),
    REGISTERED_EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "등록된 메일이 존재하지 않습니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "패스워드가 틀렸습니다."),
    UNAUTHORIZED(HttpStatus.BAD_REQUEST, "허가되지 않은 시도입니다."),
    ALREADY_USED_PASSWORD(HttpStatus.BAD_REQUEST, "이미 사용중인 비밀번호 입니다, 새로운 비밀번호를 입력해주세요."),

    // Email
    INVALID_VERIFICATION_CODE(HttpStatus.BAD_REQUEST, "인증 번호가 유효하지 않습니다."),
    EMAIL_SENDING_EXCEPTION(HttpStatus.BAD_REQUEST,"인증번호 이메일 보내기에 실패했습니다."),

    //INQUIRY
    INQUIRY_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 문의사항 입니다."),

    //BUSINESS
    BUSINESS_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 입점기업 입니다."),

    //OFFICE
    OFFICE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 지점 입니다."),

    //PLACE
    PLACE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회의실/스튜디오 입니다."),

    //DOCUMENT
    DOCUMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 문서 입니다."),

    //SCHEDULE
    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 일정 입니다."),

    //RESERVATION
    RESERVATION_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 예약 입니다."),

    // 5xx
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 에러");

    private HttpStatus httpStatus;
    private String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}

