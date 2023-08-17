package com.maleca.bookstore.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maleca.bookstore.service.exceptions.ObjectNotFoundException;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ExceptionResourcesHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	
	public ResponseEntity<StandardError> objectNotFoundException (ObjectNotFoundException e, ServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	} 

}
 