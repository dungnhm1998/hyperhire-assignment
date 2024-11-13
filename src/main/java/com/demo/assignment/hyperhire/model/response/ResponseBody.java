package com.demo.assignment.hyperhire.model.response;

import com.demo.assignment.hyperhire.model.exception.ServerError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody<T> implements Serializable {

    /**
     * @see {@link HttpStatus}
     */
    private int code;

    private String message;

    @JsonInclude(value = Include.NON_NULL)
    private List<ServerError> errors;

    @JsonInclude(value = Include.NON_NULL)
    private T data;

    public static <T> ResponseBody<T> ok() {
        return restResult(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), null, null);
    }

    public static <T> ResponseBody<T> ok(String message) {
        return restResult(HttpStatus.OK, message, null, null);
    }

    public static <T> ResponseBody<T> ok(T responseData) {
        return restResult(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), null, responseData);
    }

    public static <T> ResponseBody<T> created(T responseData) {
        return restResult(HttpStatus.CREATED, HttpStatus.CREATED.getReasonPhrase(), null, responseData);
    }

    public static <T> ResponseBody<T> failed(int code, String message) {
        return restResult(code, message, null, null);
    }

    public static <T> ResponseBody<T> failed(ServerError error) {
        return restResult(error.getServerCode(), error.getMessage(), Collections.singletonList(error), null);
    }

    public static <T> ResponseBody<T> failed(ServerError error, List<ServerError> errorsDetail) {
        return restResult(error.getServerCode(), error.getMessage(), errorsDetail, null);
    }

    public static <T> ResponseBody<T> failed(HttpStatus status, String message) {
        return restResult(status, message, null, null);
    }

    public static <T> ResponseBody<T> failed(HttpStatus status, String message, List<ServerError> error) {
        return restResult(status, message, error, null);
    }

    public static <T> ResponseBody<T> failed(HttpStatus status, String message, List<ServerError> error, T responseData) {
        return restResult(status, message, error, responseData);
    }

    public static <T> ResponseBody<T> build(HttpStatus status, String message, List<ServerError> error, T responseData) {
        return restResult(status, message, error, responseData);
    }

    private static <T> ResponseBody<T> restResult(HttpStatus code, String message, List<ServerError> error, T responseData) {
//        ResponseBody<T> body = new ResponseBody<>();
//        body.setCode(code.value());
//        body.setMessage(message);
//        body.setErrors(error);
//        body.setData(responseData);
//        return body;
        return restResult(code.value(), message, error, responseData);
    }

    private static <T> ResponseBody<T> restResult(int code, String message, List<ServerError> error, T responseData) {
        ResponseBody<T> body = new ResponseBody<>();
        body.setCode(code);
        body.setMessage(message);
        body.setErrors(error);
        body.setData(responseData);
        return body;
    }

}
