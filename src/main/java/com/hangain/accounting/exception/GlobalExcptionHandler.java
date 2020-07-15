package com.hangain.accounting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcptionHandler {
    @ExceptionHandler(ServiceException.class)
    ResponseEntity<?> handleResourceNotFoundException(ServiceException e) {
        return ResponseEntity.status(e.getStatusCode())
                .body(ErrorResponse.builder()
                        .code(e.getErrorCode())
                        .statusCode(e.getStatusCode())
                        .errorType(e.getErrorType())
                        .message(e.getMessage())
                        .build());
    }
}


