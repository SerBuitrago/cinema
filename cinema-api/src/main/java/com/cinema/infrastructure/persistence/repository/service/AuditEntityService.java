package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.AuditRepository;
import com.cinema.dominio.entity.Audit;
import com.cinema.infrastructure.persistence.entity.AuditEntity;
import com.cinema.infrastructure.persistence.mapper.AuditEntityMapper;
import com.cinema.infrastructure.persistence.repository.AuditEntityRepository;
import com.cinema.infrastructure.util.Cinema;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuditEntityService implements AuditRepository{
	
	private final AuditEntityRepository auditEntityRepository;
	private final AuditEntityMapper auditEntityMapper;
	
	@Override
	public Audit findById(Long id) {
		Optional<AuditEntity> optional = auditEntityRepository.findById(id);
		AuditEntity audit = optional.orElse(null);
		return auditEntityMapper.toDomain(audit);
	}

	@Override
	public List<Audit> findAll() {
		return auditEntityMapper.toDomainList(auditEntityRepository.findAll());
	}

	@Override
	public List<Audit> findByStatuAll(boolean statu) {
		return auditEntityMapper.toDomainList(auditEntityRepository.findByStatu(statu));
	}

	@Override
	public List<Audit> findByRangeDateRegisterAll(String start, String end) {
		String array[] = Cinema.isRangeDateRegister(start, end);
		return auditEntityMapper.toDomainList(auditEntityRepository.findByRangeDateRegister(array[0], array[1]));
	}

	@Override
	public Audit save(Audit audit) {
		return null;
	}
	
}
