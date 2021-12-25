package com.cinema.infrastructure.persistence.entity.validate;

import com.cinema.dominio.entity.Server;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.util.Cinema;

public class ServerEntityValidate {

	public static void validate(Server server) {
		if (server == null)
			throw new CinemaException("No se ha podido validar el servidor.");
		if (!Cinema.isString(server.getName()))
			throw new CinemaException("El nombre del servidor no es valido.");
		if (!Cinema.isString(server.getImage()))
			throw new CinemaException("La imagen del servidor no es valido.");
	}
}
