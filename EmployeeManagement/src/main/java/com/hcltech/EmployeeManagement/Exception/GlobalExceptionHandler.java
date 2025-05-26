package com.hcltech.EmployeeManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "ERROR");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).substring(4));  // Extract URI from the request

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

/*    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "INTERNAL_SERVER_ERROR");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).substring(4));
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGlobalException(Exception ex, WebRequest request) {

        final ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("INTERNAL_SERVER_ERROR");
        problemDetail.setDetail("message : "+ex.getMessage());
        problemDetail.setProperty("reason",ex.getMessage());
        problemDetail.setStatus(500);
        problemDetail.setProperty("severity","ERROR");

        return problemDetail;
    }

}
