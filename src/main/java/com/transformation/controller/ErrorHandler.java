package com.transformation.controller;

import com.transformation.model.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    private static final String ERROR_MESSAGE_TEMPLATE = "Handling {}. Message: {}";
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> ResponseEntityhandle(ValidationException ex) {
        LOGGER.warn(ERROR_MESSAGE_TEMPLATE, ex.getClass().getSimpleName(), ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
