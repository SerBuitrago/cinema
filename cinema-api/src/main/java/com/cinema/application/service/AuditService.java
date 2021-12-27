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
	public List<Audit> findByIdUserAll(Long idUser) {
		return auditRepository.findByIdUserAll(idUser);
	}
	
	@Override
	public List<Audit> findByTableAll(String table) {
		return auditRepository.findByTableAll(table);
	}

	@Override
	public List<Audit> findByDBAll(String db) {
		return auditRepository.findByDBAll(db);
	}

	@Override
	public List<Audit> findByActionAll(String action) {
		return auditRepository.findByActionAll(action);
	}

	@Override
	public List<Audit> findByIpPublicAll(String ipPublic) {
		return auditRepository.findByIpPublicAll(ipPublic);
	}

	@Override
	public List<Audit> findByIpLocalAll(String ipLocal) {
		return auditRepository.findByIpLocalAll(ipLocal);
	}

	@Override
	public List<Audit> findByDBAndTableAll(String db, String table) {
		return auditRepository.findByDBAndTableAll(db, table);
	}

	@Override
	public List<Audit> findByDBAndTableAndUserAll(String db, String table, Long idUser) {
		return auditRepository.findByDBAndTableAndUserAll(db, table, idUser);
	}

	@Override
	public List<Audit> findByDBAndTableAndActionAll(String db, String table, String action) {
		return auditRepository.findByDBAndTableAndActionAll(db, table, action);
	}

	@Override
	public List<Audit> findByDBAndTableAndActionAndUserAll(String db, String table, String action, Long idUser) {
		return auditRepository.findByDBAndTableAndActionAndUserAll(db, table, action, idUser);
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
