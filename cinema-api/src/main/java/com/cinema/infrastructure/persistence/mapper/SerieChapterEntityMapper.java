package com.cinema.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.SerieChapter;
import com.cinema.infrastructure.persistence.entity.SerieChapterEntity;

@Mapper(componentModel = "spring")
public interface SerieChapterEntityMapper {
	
	SerieChapter toDomain(SerieChapterEntity serieChapterEntity);

	List<SerieChapter> toDomainList(List<SerieChapterEntity> serieChapterEntity);

	SerieChapterEntity toEntity(SerieChapter serieChapter);

	List<SerieChapterEntity> toEntityList(List<SerieChapter> serieChapter);
}
