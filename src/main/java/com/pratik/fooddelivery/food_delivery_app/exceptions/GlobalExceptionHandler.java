package com.pratik.fooddelivery.food_delivery_app.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<Object> handleInvalidIdException(InvalidIdException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
