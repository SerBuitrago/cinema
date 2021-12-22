package com.cinema.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.Image;
import com.cinema.infrastructure.persistence.entity.ImageEntity;

@Mapper(componentModel = "spring")
public interface ImageEntityMapper {
	
	Image toDomain(ImageEntity imageEntity);

	ImageEntity toEntity(Image image);
}
