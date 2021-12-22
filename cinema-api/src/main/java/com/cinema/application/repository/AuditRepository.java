package com.cinema.application.repository;

import java.util.List;

import com.cinema.dominio.entity.Audit;

public interface AuditRepository {

	Audit findById(Long id);

	List<Audit> findAll();
	
	List<Audit> findByStatuAll(boolean statu);
	
	List<Audit> findByRangeDateRegisterAll(String start, String end);
	
	Audit save(Audit audit);
}
