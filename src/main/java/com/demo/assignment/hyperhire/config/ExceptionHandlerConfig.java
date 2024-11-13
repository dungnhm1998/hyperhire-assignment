package com.demo.assignment.hyperhire.config;

import com.demo.assignment.hyperhire.model.exception.BadRequestException;
import com.demo.assignment.hyperhire.model.exception.ServerError;
import com.demo.assignment.hyperhire.model.response.ResponseBody;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@Log4j2
@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<Object> handlerBadRequestException(BadRequestException e) {
		String message = HttpStatus.BAD_REQUEST.getReasonPhrase();
		if (!StringUtils.isEmpty(e.getMessage())) {
			message = e.getMessage();
		}
		ResponseBody<Object> responseBody = ResponseBody.build(HttpStatus.BAD_REQUEST, message, e.getErrors(), null);
		return new ResponseEntity<Object>(responseBody, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex) {
		log.error(ex.getMessage());
		ex.printStackTrace();
		return new ResponseEntity<>(ResponseBody.failed(ServerError.INTERNAL_SERVER_ERRROR), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
