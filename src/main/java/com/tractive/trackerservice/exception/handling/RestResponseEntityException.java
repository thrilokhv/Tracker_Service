package com.tractive.trackerservice.exception.handling;

import com.tractive.trackerservice.exception.ResourceNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestResponseEntityException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> handleOwnerIdNotFound(ResourceNotFoundException ex) {
       final Error error = new Error(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, ex.getMessage(), Collections.emptyList());
       return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }
}
