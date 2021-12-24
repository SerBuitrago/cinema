package com.cinema.infrastructure.persistence.entity.validate;

import com.cinema.dominio.entity.ImageMovie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.util.Cinema;

public class ImageMovieEntityValidate {
	
	public static void validate(ImageMovie imageMovie) {
		if(imageMovie == null)
			throw new CinemaException("No se ha podido validar la imagen de la pelicula.");
		if(!Cinema.isLong(imageMovie.getIdMovie()))
			throw new CinemaException("No se ha podido validar la pelicula.");
		if(!Cinema.isString(imageMovie.getPath()))
			throw new CinemaException("No se ha podido validar la imagen.");
	}
}
