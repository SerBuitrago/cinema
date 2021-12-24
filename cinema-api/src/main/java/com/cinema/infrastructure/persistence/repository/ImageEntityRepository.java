package com.cinema.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.infrastructure.persistence.entity.ImageMovieEntity;

@Repository
public interface ImageEntityRepository extends JpaRepository<ImageMovieEntity, Long>{
	
	List<ImageMovieEntity> findByStatu(boolean statu);
	
	@Query(nativeQuery = false, value = "SELECT im FROM ImageMovieEntity im WHERE im.dateRegister BETWEEN :start AND :end ORDER BY im.dateRegister")
	List<ImageMovieEntity> findByRangeDateRegister(@Param("start") String start, @Param("end") String end);
}
