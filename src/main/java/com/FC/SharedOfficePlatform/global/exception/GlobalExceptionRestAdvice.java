package com.FC.SharedOfficePlatform.global.exception;

import com.FC.SharedOfficePlatform.global.util.ResponseDTO;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionRestAdvice {

    // @ExceptionHandler annotation을 누락시켜서, Custom Exception 대신 INTERNAL_SERVER_ERROR가 나왔었음.
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ResponseDTO<Void>> applicationException(ApplicationException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
            .status(e.getErrorCode().getHttpStatus())
            .body(ResponseDTO.error(e.getErrorCode()));
    }

    // Request Body 형식이 틀린 경우, 400 (BAD_REQUEST) 에러 띄우도록 함 - 초기 셋업 이후, 24.05.19 추가
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO<Void>> httpMessageNotReadableException(
        HttpMessageNotReadableException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ResponseDTO.errorWithMessage(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    //DTO Validation 실패 시 어떤 정보가 잘못 됐는지 메시지 자세히 출력 - 초기 셋업 이후, 24.05.19 추가
    //bindException ~ getSortedFiledErrors
    @ExceptionHandler(BindException.class)
    public ResponseDTO<Void> bindException(BindException e) {
        log.warn("[bindException] Message = {}",
            NestedExceptionUtils.getMostSpecificCause(e).getMessage());

        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = getSortedFieldErrors(bindingResult);

        String response = fieldErrors.stream()
            .map(fieldError -> String.format("%s (%s=%s)",
                    fieldError.getDefaultMessage(),
                    fieldError.getField(),
                    fieldError.getRejectedValue()
                )
            ).collect(Collectors.joining(", "));
        return ResponseDTO.errorWithMessage(HttpStatus.BAD_REQUEST, response);
    }

    //DTO Validation 실패 시 어떤 정보가 잘못 됐는지 메시지 자세히 출력 - 초기 셋업 이후, 24.05.19 추가
    //bindException ~ getSortedFiledErrors
    private List<FieldError> getSortedFieldErrors(BindingResult bindingResult) {
        List<String> declaredFields = Arrays.stream(
                Objects.requireNonNull(bindingResult.getTarget()).getClass().getDeclaredFields())
            .map(Field::getName)
            .toList();

        return bindingResult.getFieldErrors().stream()
            .filter(fieldError -> declaredFields.contains(fieldError.getField()))
            .sorted(Comparator.comparingInt(fe -> declaredFields.indexOf(fe.getField())))
            .collect(Collectors.toList());
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ResponseDTO<Void>> dbException(DataAccessException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ResponseDTO.errorWithMessage(HttpStatus.INTERNAL_SERVER_ERROR, "디비 에러!"));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDTO<Void>> serverException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ResponseDTO.errorWithMessage(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러!"));
    }
}
