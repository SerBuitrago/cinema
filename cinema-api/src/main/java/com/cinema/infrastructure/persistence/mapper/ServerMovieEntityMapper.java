package com.cinema.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.ServerMovie;
import com.cinema.infrastructure.persistence.entity.ServerMovieEntity;

@Mapper(componentModel = "spring")
public interface ServerMovieEntityMapper {
	
	ServerMovie toDomain(ServerMovieEntity serverMovieEntity);

	List<ServerMovie> toDomainList(List<ServerMovieEntity> serverMovieEntity);

	ServerMovieEntity toEntity(ServerMovie serverMovie);

	List<ServerMovieEntity> toEntityList(List<ServerMovie> serverMovie);
}
