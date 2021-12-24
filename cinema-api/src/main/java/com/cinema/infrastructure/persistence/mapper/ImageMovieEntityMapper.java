package com.cinema.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.ImageMovie;
import com.cinema.infrastructure.persistence.entity.ImageMovieEntity;

@Mapper(componentModel = "spring")
public interface ImageMovieEntityMapper {
	
	ImageMovie toDomain(ImageMovieEntity imageMovieEntity);
	
	List<ImageMovie> toDomainList(List<ImageMovieEntity> imageMovieEntity);

	ImageMovieEntity toEntity(ImageMovie imageMovie);
	
	List<ImageMovieEntity> toEntityList(List<ImageMovie> imageMovie);
}
