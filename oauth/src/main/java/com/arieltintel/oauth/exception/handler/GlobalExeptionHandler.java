package com.arieltintel.oauth.exception.handler;

import com.arieltintel.oauth.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(UserNotFoundException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("messageError", exception.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

}
