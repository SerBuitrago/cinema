package com.cinema.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.GenderMovie;
import com.cinema.infrastructure.persistence.entity.GenderMovieEntity;

@Mapper(componentModel = "spring")
public interface GenderMovieEntityMapper {
	
	GenderMovie toDomain(GenderMovieEntity genderMovieEntity);

	GenderMovieEntity toEntity(GenderMovie genderMovie);
}
