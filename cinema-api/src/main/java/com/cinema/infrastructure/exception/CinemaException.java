package com.cinema.infrastructure.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * @project cinema-api.
 * @author Sergio Stives Barrios Buitrago.
 * @Github https://github.com/SerBuitrago.
 * @version 1.0.0.
 */
@Getter
public class CinemaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;

	
	public CinemaException(String message) {
		this(HttpStatus.NOT_FOUND, message);
	}
	
	public CinemaException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}
	
}
