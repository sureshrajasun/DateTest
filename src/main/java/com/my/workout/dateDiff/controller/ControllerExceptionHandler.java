package com.my.workout.dateDiff.controller;

import com.my.workout.dateDiff.dto.ErrorMessage;
import com.my.workout.dateDiff.exception.DateDifferenceException;
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
        log.info("Exception occurred while finding the date difference.", ex.getMessage());
        return new ResponseEntity<ErrorMessage>(ErrorMessage.builder().message(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorMessage> globalException(Exception ex, WebRequest request) {
        log.info("Exception occurred.", ex.getMessage());
        return new ResponseEntity<ErrorMessage>(ErrorMessage.builder().message(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}