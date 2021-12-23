package com.cinema.infrastructure.persistence.entity.validate;

import com.cinema.dominio.entity.Gender;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.util.Cinema;

public class GenderEntityValidate {
	public static void validate(Gender gender) {
		if (gender == null)
			throw new CinemaException("No se ha podido validar el genero.");
		if(!Cinema.isLong(gender.getId()))
			throw new CinemaException("El id del genero no es valido.");
	}
	
	public static void validateName(Gender gender) {
		validate(gender);
		if(!Cinema.isString(gender.getName()))
			throw new CinemaException("El nombre del genero no es valido.");
	}
}
