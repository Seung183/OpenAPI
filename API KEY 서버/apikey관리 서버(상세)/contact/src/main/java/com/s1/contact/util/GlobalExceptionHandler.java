package com.s1.contact.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiKeyException.class)
    @ResponseBody
    public ResponseEntity<ApiErrorInfo> handleApiKeyException(ApiKeyException e){
        ApiErrorInfo error = new ApiErrorInfo("API Key 처리 오류: " + e.getMessage(),e.getStatus());
        ResponseEntity<ApiErrorInfo> entity = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

        return entity;
    }
}
