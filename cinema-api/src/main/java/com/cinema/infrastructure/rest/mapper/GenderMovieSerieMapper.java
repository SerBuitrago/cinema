package com.cinema.infrastructure.rest.mapper;

import org.mapstruct.Mapper;

import com.cinema.dominio.GenderMovieSerie;
import com.cinema.infrastructure.rest.dto.GenderMovieSerieDTO;

@Mapper(componentModel = "spring")
public interface GenderMovieSerieMapper {
	
	GenderMovieSerieDTO toDto(GenderMovieSerie genderMovieSerie);

	GenderMovieSerie toDomain(GenderMovieSerieDTO genderMovieSerieDTO);
}
