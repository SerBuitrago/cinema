package com.cinema.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.ServerSerieChapter;
import com.cinema.infrastructure.persistence.entity.ServerSerieChapterEntity;

@Mapper(componentModel = "spring")
public interface ServerSerieChapterEntityMapper {
	
	ServerSerieChapter toDomain(ServerSerieChapterEntity serverSerieChapterEntity);

	List<ServerSerieChapter> toDomainList(List<ServerSerieChapterEntity> serverSerieChapterEntity);

	ServerSerieChapterEntity toEntity(ServerSerieChapter serverSerieChapter);

	List<ServerSerieChapterEntity> toEntityList(List<ServerSerieChapter> serverSerieChapter);
}
