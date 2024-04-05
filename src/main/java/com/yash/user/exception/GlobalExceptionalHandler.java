package com.yash.user.exception;


import com.yash.user.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exc) {
        String message = exc.getMessage();

        ApiResponse response = ApiResponse.builder().message(message).success(true).
                status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);

    }
}