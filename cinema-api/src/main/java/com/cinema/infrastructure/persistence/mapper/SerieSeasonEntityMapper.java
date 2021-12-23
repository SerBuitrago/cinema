package com.cinema.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.SerieSeason;
import com.cinema.infrastructure.persistence.entity.SerieSeasonEntity;

@Mapper(componentModel = "spring")
public interface SerieSeasonEntityMapper {
	
	SerieSeason toDomain(SerieSeasonEntity serieSeasonEntity);

	List<SerieSeason> toDomainList(List<SerieSeasonEntity> serieSeasonEntity);

	SerieSeasonEntity toEntity(SerieSeason serieSeason);

	List<SerieSeasonEntity> toEntityList(List<SerieSeason> serieSeason);
}
