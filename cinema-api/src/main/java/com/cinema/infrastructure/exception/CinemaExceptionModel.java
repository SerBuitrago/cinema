package com.cinema.infrastructure.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project cinema-api.
 * @author Sergio Stives Barrios Buitrago.
 * @Github https://github.com/SerBuitrago.
 * @version 1.0.0.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaExceptionModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	private String exception;
	private String path;
	private int statu;
	
	public static CinemaExceptionModel builder(Exception e, int code) {
		return new CinemaExceptionModel(e.getMessage(), e.getClass().getSimpleName(), e.getLocalizedMessage(), code);
	}
}
