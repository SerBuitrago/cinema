package com.cinema.infrastructure.persistence.entity.validate;

import com.cinema.dominio.entity.GenderMovie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.util.Cinema;

public class GenderMovieEntityValidate {
	
	public static void validate(GenderMovie genderMovie) {
		if(genderMovie == null)
			throw new CinemaException("No se ha podido validar el genero de la pelicula.");
		if(!Cinema.isLong(genderMovie.getIdMovie()))
			throw new CinemaException("No se ha recibido la pelicula.");
		if(!Cinema.isLong(genderMovie.getIdGender()))
			throw new CinemaException("No se ha recibido el genero.");
	}
}
