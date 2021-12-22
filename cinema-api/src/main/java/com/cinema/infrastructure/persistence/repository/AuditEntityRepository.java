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
	
	@Query(nativeQuery = false, value = "SELECT a FROM AuditEntity a WHERE a.dateRegister BETWEEN :start AND :end ORDER BY a.dateRegister")
	List<AuditEntity> findByRangeDateRegister(@Param("start") String start, @Param("end") String end);
}
