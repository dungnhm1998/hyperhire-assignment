package com.demo.assignment.hyperhire.model.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class SystemException extends RuntimeException {
	
	private HttpStatus code;
	private String message;

    private List<ServerError> errors;
    public SystemException(HttpStatus code, String message, List<ServerError> errors) {
        super(message);
        this.code = code;
        this.message = message;
        this.errors = errors;
    }
}

