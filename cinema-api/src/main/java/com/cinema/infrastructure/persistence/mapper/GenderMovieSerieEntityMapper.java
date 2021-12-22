package com.cinema.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.GenderMovieSerie;
import com.cinema.infrastructure.persistence.entity.GenderMovieSerieEntity;

@Mapper(componentModel = "spring")
public interface GenderMovieSerieEntityMapper {
	
	GenderMovieSerie toDomain(GenderMovieSerieEntity genderMovieSerieEntity);

	GenderMovieSerieEntity toEntity(GenderMovieSerie genderMovieSerie);
}
