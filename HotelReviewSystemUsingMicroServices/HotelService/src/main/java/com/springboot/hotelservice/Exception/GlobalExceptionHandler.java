package com.springboot.hotelservice.Exception;

import com.springboot.hotelservice.Exception.pojo.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler
    ResponseEntity<ExceptionResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException)
    {
        String message=resourceNotFoundException.getMessage();
        ExceptionResponse exceptionResponse=ExceptionResponse.builder().status(false).message(message).httpStatus(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(exceptionResponse);
    }
}
