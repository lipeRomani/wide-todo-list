package com.wspot.todo.controllers.adivices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityExistsException;

@ControllerAdvice
public class EntityExistsHandler {

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Response> handleException(EntityExistsException ex) {
        return new ResponseEntity<>(new Response(ex.getMessage()), HttpStatus.CONFLICT);
    }
}
