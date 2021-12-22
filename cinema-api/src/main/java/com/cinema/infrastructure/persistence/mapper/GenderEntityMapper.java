package com.cinema.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.Gender;
import com.cinema.infrastructure.persistence.entity.GenderEntity;

@Mapper(componentModel = "spring")
public interface GenderEntityMapper {
	
	Gender toDomain(GenderEntity genderEntity);

	GenderEntity toEntity(Gender gender);
}
