package com.nuvu.usermanagement.exception;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ServerApiErrorHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> exception(MethodArgumentNotValidException methodAtgumentNotValid) {
		List<ObjectError> errors = methodAtgumentNotValid.getAllErrors();
		String errorMessage = "";
		if (!errors.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			errors.forEach(error -> builder.append(" " + error.getDefaultMessage()).append("\n"));
			errorMessage = builder.toString();
		} else {
			errorMessage = "MethodArgumentNotValidException occured.";
		}
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handle(ConstraintViolationException constraintViolationException) {
		Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
		String errorMessage = "";
		if (!violations.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			violations.forEach(violation -> builder.append(" " + violation.getMessage()).append("\n"));
			errorMessage = builder.toString();
		} else {
			errorMessage = "ConstraintViolationException occured.";
		}
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public ResponseEntity<String> handle(DataIntegrityViolationException dataIntegrityViolationException) {
//		return new ResponseEntity<>("associated id does not exist.", HttpStatus.BAD_REQUEST);
//	}

}
