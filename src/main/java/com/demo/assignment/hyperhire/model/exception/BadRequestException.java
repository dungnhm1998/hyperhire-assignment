package com.demo.assignment.hyperhire.model.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
public class BadRequestException extends SystemException {

    public BadRequestException() {
        this(null,null);
    }
    public BadRequestException(ServerError serverError) {
        this(Collections.singletonList(serverError));
    }
    public BadRequestException(List<ServerError> serverErrors) {
        this(HttpStatus.BAD_REQUEST.getReasonPhrase(), serverErrors);
    }
    public BadRequestException(String message, List<ServerError> serverErrors) {
        super(HttpStatus.BAD_REQUEST, message, serverErrors);
    }
}
