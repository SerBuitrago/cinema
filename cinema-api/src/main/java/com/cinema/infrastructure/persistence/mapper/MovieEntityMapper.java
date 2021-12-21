package com.cinema.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.Movie;
import com.cinema.infrastructure.persistence.entity.MovieEntity;

@Mapper(componentModel = "spring")
public interface MovieEntityMapper {
	
	Movie toDomain(MovieEntity movieEntity);
	
	List<Movie> toDomainList(List<MovieEntity> movieEntity);

	MovieEntity toEntity(Movie movie);
	
	List<MovieEntity> toEntityList(List<Movie> movie);
}
