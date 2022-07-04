package io.spring.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import io.spring.demo.exception.GenericApiException;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(value = GenericApiException.class)
    protected ResponseEntity<Object> handleGenericApiException(GenericApiException ex, WebRequest request) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
