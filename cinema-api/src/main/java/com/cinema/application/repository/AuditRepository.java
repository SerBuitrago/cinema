package com.cinema.application.repository;

import java.util.List;

import com.cinema.dominio.entity.Audit;

public interface AuditRepository {

	Audit findById(Long id);

	List<Audit> findAll();
	
	List<Audit> findByIdUserAll(Long idUser);
	
	List<Audit> findByTableAll(String table);
	
	List<Audit> findByDBAll(String db);
	
	List<Audit> findByActionAll(String action);
	
	List<Audit> findByIpPublicAll(String ipPublic);
	
	List<Audit> findByIpLocalAll(String ipLocal);
	
	List<Audit> findByDBAndTableAll(String db, String table);
	
	List<Audit> findByDBAndTableAndUserAll(String db, String table, Long idUser);
	
	List<Audit> findByDBAndTableAndActionAll(String db, String table, String action);
	
	List<Audit> findByDBAndTableAndActionAndUserAll(String db, String table, String action, Long idUser);
	
	List<Audit> findByStatuAll(boolean statu);
	
	List<Audit> findByRangeDateRegisterAll(String start, String end);
	
	Audit save(Audit audit);
}
