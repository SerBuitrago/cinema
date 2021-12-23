package com.cinema.infrastructure.persistence.entity.validate;

import com.cinema.dominio.entity.Movie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.util.Cinema;

public class MovieEntityValidate {
	
	public static void validate(Movie movie) {
		if (movie == null)
			throw new CinemaException("No se ha podido validar la pelicula.");
		if(!Cinema.isLong(movie.getId()))
			throw new CinemaException("El id de la pelicula no es valido.");
	}
}
