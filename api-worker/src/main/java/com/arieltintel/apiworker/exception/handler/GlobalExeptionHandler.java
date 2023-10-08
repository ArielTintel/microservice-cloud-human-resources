package com.arieltintel.apiworker.exception.handler;

import com.arieltintel.apiworker.exception.WorkerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(WorkerNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(WorkerNotFoundException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("messageError", exception.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

}
