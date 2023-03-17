package com.qantas.common.datediff.controller;

import com.qantas.common.datediff.dto.ErrorMessage;
import com.qantas.common.datediff.exception.DateDifferenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {DateDifferenceException.class})
    public ResponseEntity<ErrorMessage> dateDifferenceException(DateDifferenceException ex, WebRequest request) {
        log.info("Exception occurred while finding the date difference. {}", ex.getMessage());
        return new ResponseEntity<>(ErrorMessage.builder()
                                                        .message(ex.getMessage())
                                                        .errorCode(HttpStatus.BAD_REQUEST.toString())
                                                        .type("Invalid input param.")
                                                        .status("ERROR")
                                                        .build(),
                                                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorMessage> globalException(Exception ex, WebRequest request) {
        log.info("Exception occurred. {}", ex.getMessage());
        return new ResponseEntity<>(ErrorMessage.builder()
                                                        .message(ex.getMessage())
                                                        .errorCode(HttpStatus.BAD_REQUEST.toString())
                                                        .type("Something went wrong")
                                                        .status("ERROR")
                                                        .build(),
                                                HttpStatus.BAD_REQUEST);
    }
}