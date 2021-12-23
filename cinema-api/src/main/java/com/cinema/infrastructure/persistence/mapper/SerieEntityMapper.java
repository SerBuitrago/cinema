package com.cinema.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.Serie;
import com.cinema.infrastructure.persistence.entity.SerieEntity;

@Mapper(componentModel = "spring")
public interface SerieEntityMapper {
	
	Serie toDomain(SerieEntity serieEntity);

	List<Serie> toDomainList(List<SerieEntity> serieEntity);

	SerieEntity toEntity(Serie serie);

	List<SerieEntity> toEntityList(List<Serie> Serie);
}
