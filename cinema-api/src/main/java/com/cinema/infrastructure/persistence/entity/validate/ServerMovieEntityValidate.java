package com.cinema.infrastructure.persistence.entity.validate;

import com.cinema.dominio.entity.ServerMovie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.util.Cinema;

public class ServerMovieEntityValidate {
	
	public static void validate(ServerMovie serverMovie) {
		if (serverMovie == null)
			throw new CinemaException("No se ha podido validar el servidor de la pelicula.");
		if(!Cinema.isLong(serverMovie.getIdServer()))
			throw new CinemaException("El id del servidor no es valido.");
		if(!Cinema.isLong(serverMovie.getIdMovie()))
			throw new CinemaException("El id de la pelicula no es valida.");
		if (!Cinema.isString(serverMovie.getPath()))
			throw new CinemaException("La URL de la pelicula no es valido.");
		if (!Cinema.isString(serverMovie.getTime()))
			throw new CinemaException("La duración de la pelicula no es valida.");
	}
}
