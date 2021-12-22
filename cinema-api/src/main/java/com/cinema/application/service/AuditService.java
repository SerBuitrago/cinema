package com.cinema.application.service;

import java.util.List;

import com.cinema.application.repository.AuditRepository;
import com.cinema.dominio.entity.Audit;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuditService implements AuditRepository{
	
	private final AuditRepository auditRepository;
	
	@Override
	public Audit findById(Long id) {
		return auditRepository.findById(id);
	}

	@Override
	public List<Audit> findAll() {
		return auditRepository.findAll();
	}

	@Override
	public List<Audit> findByStatuAll(boolean statu) {
		return auditRepository.findByStatuAll(statu);
	}

	@Override
	public List<Audit> findByRangeDateRegisterAll(String start, String end) {
		return auditRepository.findByRangeDateRegisterAll(start, end);
	}

	@Override
	public Audit save(Audit audit) {
		return auditRepository.save(audit);
	}

}
