package com.springboot.ratingservices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Map<Object,Object>> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException)
    {
        String message=resourceNotFoundException.getMessage();
        Map<Object,Object> response=new HashMap<>();
        response.put("status",false);
        response.put("message",message);
        response.put("httpStatus", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(response);
    }
}
