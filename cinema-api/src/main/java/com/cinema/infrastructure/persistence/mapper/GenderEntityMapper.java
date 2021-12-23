package com.cinema.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.Gender;
import com.cinema.infrastructure.persistence.entity.GenderEntity;

@Mapper(componentModel = "spring")
public interface GenderEntityMapper {

	Gender toDomain(GenderEntity genderEntity);

	List<Gender> toDomainList(List<GenderEntity> genderEntity);

	GenderEntity toEntity(Gender gender);

	List<GenderEntity> toEntity(List<Gender> gender);
}
