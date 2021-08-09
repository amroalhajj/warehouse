package com.clustered.data.warehouse.warehouse.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler  {

	private static final long serialVersionUID = 1L;
	
	private final AllErrorMassages allErrorMessages;
	
	public RestExceptionHandler(AllErrorMassages allErrorMessages) {
		this.allErrorMessages = allErrorMessages;
	}
	
	@ExceptionHandler(DealNotFoundException.class)
	public ResponseEntity<Object> handleInvalidFieldValu(DealNotFoundException e) {
		ErrorInfo errorInfo = allErrorMessages
								.byClass(e)
								.orElseGet(() -> generalErrorInfo(e));
		return ResponseEntity.status(errorInfo.getRestStatus()).body(errorInfo);
	}
	
	private ErrorInfo generalErrorInfo(RuntimeException e) {
		
		return ErrorInfo
			.builder()
			.errorCode(0)
			.restStatus(HttpStatus.BAD_REQUEST.value())
			.msg(e.getMessage())
			.build();
	}

//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<Object> handleGeneralException(RuntimeException e) {
//		return ResponseEntity.ok(generalErrorInfo(e));
//	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
	  MethodArgumentNotValidException ex, 
	  HttpHeaders headers, 
	  HttpStatus status, 
	  WebRequest request) {
	    List<String> errors = new ArrayList<String>();
	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	        errors.add(error.getField() + ": " + error.getDefaultMessage());
	    }
	    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	        errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
	    }
	    
	    ApiError apiError = 
	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	    return handleExceptionInternal(
	      ex, apiError, headers, apiError.getStatus(), request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
	  MissingServletRequestParameterException ex, HttpHeaders headers, 
	  HttpStatus status, WebRequest request) {
	    String error = ex.getParameterName() + " parameter is missing";
	    
	    ApiError apiError = 
	      new ApiError(HttpStatus.BAD_REQUEST, "", error);
	    return new ResponseEntity<Object>(
	      apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(
	  ConstraintViolationException ex, WebRequest request) {
	    List<String> errors = new ArrayList<String>();
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	        errors.add(violation.getRootBeanClass().getName() + " " + 
	          violation.getPropertyPath() + ": " + violation.getMessage());
	    }

	    ApiError apiError = 
	      new ApiError(HttpStatus.BAD_REQUEST, "", errors);
	    return new ResponseEntity<Object>(
	      apiError, new HttpHeaders(), apiError.getStatus());
	}

}
