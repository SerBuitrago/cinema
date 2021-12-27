package com.cinema.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.infrastructure.persistence.entity.AuditEntity;

@Repository
public interface AuditEntityRepository extends JpaRepository<AuditEntity, Long> {
	
	List<AuditEntity> findByStatu(boolean statu);
	
	List<AuditEntity> findByIdUser(Long idUser);
	
	List<AuditEntity> findByTable(String table);
	
	List<AuditEntity> findByDatabase(String database);
	
	List<AuditEntity> findByAction(String action);
	
	List<AuditEntity> findByIpPublic(String ipPublic);
	
	List<AuditEntity> findByIpLocal(String ipLocal);
	
	@Query(nativeQuery = false, value = "SELECT a FROM AuditEntity a WHERE a.database = :db AND a.table = :table")
	List<AuditEntity> findByDBAndTableAll(@Param("db") String db, @Param("table") String table);
	
	@Query(nativeQuery = false, value = "SELECT a FROM AuditEntity a WHERE a.database = :db AND a.table = :table AND a.idUser = :idUser")
	List<AuditEntity> findByDBAndTableAndUserAll(@Param("db") String db, @Param("table") String table, @Param("idUser") Long idUser);
	
	@Query(nativeQuery = false, value = "SELECT a FROM AuditEntity a WHERE a.database = :db AND a.table = :table AND a.action = :action")
	List<AuditEntity> findByDBAndTableAndActionAll(@Param("db") String db, @Param("table") String table, @Param("action") String action);
	
	@Query(nativeQuery = false, value = "SELECT a FROM AuditEntity a WHERE a.database = :db AND a.table = :table AND a.action = :action AND a.idUser = :idUser")
	List<AuditEntity> findByDBAndTableAndActionAndUserAll(@Param("db") String db, @Param("table") String table, @Param("action") String action, @Param("idUser") Long idUser);
	
	@Query(nativeQuery = false, value = "SELECT a FROM AuditEntity a WHERE a.dateRegister BETWEEN :start AND :end ORDER BY a.dateRegister")
	List<AuditEntity> findByRangeDateRegister(@Param("start") String start, @Param("end") String end);
}
