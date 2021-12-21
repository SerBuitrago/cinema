package com.cinema.infrastructure.rest.mapper;

import org.mapstruct.Mapper;

import com.cinema.dominio.Gender;
import com.cinema.infrastructure.rest.dto.GenderDTO;

@Mapper(componentModel = "spring")
public interface GenderMapper {
	
	GenderDTO toDto(Gender gender);

	Gender toDomain(GenderDTO genderDTO);
}
