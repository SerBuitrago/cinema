package com.cinema.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;

import com.cinema.dominio.Movie;
import com.cinema.infrastructure.persistence.entity.MovieEntity;

@Mapper(componentModel = "spring")
public interface MovieEntityMapper {
	
	Movie toDomain(MovieEntity movieEntity);

	MovieEntity toEntity(Movie movie);
}
