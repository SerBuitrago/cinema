package com.cinema.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.infrastructure.persistence.entity.ServerEntity;

@Repository
public interface ServerEntityRepository extends JpaRepository<ServerEntity, Long>{
	
	ServerEntity findByName(String name);
	
	List<ServerEntity> findByStatu(boolean statu);
	
	@Query(nativeQuery = false, value = "SELECT s FROM ServerEntity s WHERE s.dateRegister BETWEEN :start AND :end ORDER BY s.dateRegister")
	List<ServerEntity> findByRangeDateRegister(@Param("start") String start, @Param("end") String end);
}
