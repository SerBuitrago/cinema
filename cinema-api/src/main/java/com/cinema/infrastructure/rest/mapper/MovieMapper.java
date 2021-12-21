package com.cinema.infrastructure.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.Movie;
import com.cinema.infrastructure.rest.dto.MovieDTO;

@Mapper(componentModel = "spring")
public interface MovieMapper {
	
	MovieDTO toDto(Movie movie);
	
	List<MovieDTO> toDtoList(List<Movie> movie);

	Movie toDomain(MovieDTO movieDTO);
	
	List<Movie> toDomain(List<MovieDTO> movieDTO);
}
