package com.cinema.infrastructure.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @project cinema-api.
 * @author Sergio Stives Barrios Buitrago.
 * @Github https://github.com/SerBuitrago.
 * @version 1.0.0.
 */
@ControllerAdvice
public class CinemaExceptionHandler {

	private static final Map<String, Integer> STATUS = new HashMap<>();
	
	/**
	 * Method that allows building the exception occurred in class CinemaException.
	 * @param request, Represents the type of exception.
	 * @param exception, Represents the exception message.
	 * @return Building the exception.
	 */
	@ExceptionHandler(CinemaException.class)
	public final ResponseEntity<CinemaExceptionModel> AllExceptions(HttpServletRequest request, Exception exception) {
		ResponseEntity<CinemaExceptionModel> result;
		Integer code = getStatus(exception);
		code = (code == null) ? HttpStatus.INTERNAL_SERVER_ERROR.value() : code;
		CinemaExceptionModel error = new CinemaExceptionModel(exception.getMessage(),
				exception.getClass().getSimpleName(), request.getRequestURI(), code);
		result = new ResponseEntity<>(error, HttpStatus.valueOf(code));
		exception.printStackTrace();
		return result;
	}

	/**
	 * Method that allows knowing the type of exception.
	 * @param e, Represents the exception message.
	 * @return Building the status.
	 */
	private Integer getStatus(Exception e) {
		if (e instanceof CinemaException) {
			CinemaException ex = (CinemaException) e;
			if (ex.getHttpStatus() != null) {
				return ex.getHttpStatus().value();
			}
		}
		return STATUS.get(e.getClass().getSimpleName());
	}
}
