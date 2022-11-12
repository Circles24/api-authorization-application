package com.cs.cdw.web.apiauthorization.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Error.class)
    public ResponseEntity<ErrorResponse> handleError(Error error) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(error.getErrorCode())
                .errorName(error.getErrorName())
                .id(error.getId())
                .message(error.getMessage())
                .source(error.getSource())
                .statusCode(error.getStatusCode())
                .timestamp(error.getTimestamp())
                .build();

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(errorResponse.getStatusCode()));
    }
}