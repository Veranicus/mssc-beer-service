package com.patrikpolacek.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErroHandler(ConstraintViolationException e) {
        List<String> errorsList = new ArrayList<>();
        e.getConstraintViolations().forEach(constraintViolation -> {
            errorsList.add(constraintViolation.toString());
        });
        return new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
    }

}
