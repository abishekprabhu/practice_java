package com.hcltech.EmployeeManagement.Exception;

import org.springframework.validation.Errors;

public class MethodArgumentNotValidException extends RuntimeException {
    private String message;

    public MethodArgumentNotValidException(String message) {
        super(message);
        this.message = message;
    }

    public Errors getBindingResult() {
        throw new UnsupportedOperationException("BindingResult is not available in this context.");
    }
}
