package com.cinema.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.infrastructure.persistence.entity.MovieEntity;

@Repository
public interface MovieRepositoryData extends JpaRepository<MovieEntity, Long>{
	
	MovieEntity findByName(String name);
	
	List<MovieEntity> findByStatu(boolean statu);
	
	@Query(nativeQuery = false, value = "SELECT m FROM MovieEntity m WHERE m.dateRegister BETWEEN :start AND :end ORDER BY m.dateRegister")
	List<MovieEntity> findByRangeDateRegister(@Param("start") String start, @Param("end") String end);
}
