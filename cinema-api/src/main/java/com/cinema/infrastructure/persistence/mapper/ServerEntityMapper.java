package com.cinema.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.Server;
import com.cinema.infrastructure.persistence.entity.ServerEntity;

@Mapper(componentModel = "spring")
public interface ServerEntityMapper {
	
	Server toDomain(ServerEntity serverEntity);

	List<Server> toDomainList(List<ServerEntity> serverEntity);

	ServerEntity toEntity(Server server);

	List<ServerEntity> toEntityList(List<Server> server);
}
