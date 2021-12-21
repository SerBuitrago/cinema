package com.cinema.infrastructure.rest.mapper;

import org.mapstruct.Mapper;

import com.cinema.dominio.Image;
import com.cinema.infrastructure.rest.dto.ImageDTO;

@Mapper(componentModel = "spring")
public interface ImageMapper {
	
	ImageDTO toDto(Image image);

	Image toDomain(ImageDTO imageDTO);
}
