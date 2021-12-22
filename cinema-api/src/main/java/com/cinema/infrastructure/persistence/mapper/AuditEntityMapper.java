package com.cinema.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cinema.dominio.entity.Audit;
import com.cinema.infrastructure.persistence.entity.AuditEntity;

@Mapper(componentModel = "spring")
public interface AuditEntityMapper {

	Audit toDomain(AuditEntity auditEntity);
	
	List<Audit> toDomainList(List<AuditEntity> auditEntity);

	AuditEntity toEntity(Audit audit);
	
	List<AuditEntity> toEntityList(List<Audit> audit);
}
