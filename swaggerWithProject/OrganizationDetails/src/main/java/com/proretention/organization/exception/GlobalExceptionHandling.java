package com.proretention.organization.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFound ex, WebRequest request) {
	    ErrorDetails message = new ErrorDetails(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(0),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorDetails>(message, HttpStatus.NOT_FOUND);
	  }

	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception ex, WebRequest request) {
		  ErrorDetails message = new ErrorDetails(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(0),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorDetails>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
