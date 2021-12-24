package com.cinema.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.infrastructure.persistence.entity.GenderMovieEntity;

@Repository
public interface GenderMovieEntityRepository extends JpaRepository<GenderMovieEntity, Long>{
	
	@Query(nativeQuery = false, value = "SELECT gm FROM GenderMovieEntity gm WHERE gm.idMovie= :idMovie AND gm.idGender= :idGender")
	GenderMovieEntity findByMovieAndGender(@Param("idMovie") Long idMovie, @Param("idGender") Long idGender);

	List<GenderMovieEntity> findByStatu(boolean statu);
	
	@Query(nativeQuery = false, value = "SELECT gm FROM GenderMovieEntity gm WHERE gm.dateRegister BETWEEN :start AND :end ORDER BY gm.dateRegister")
	List<GenderMovieEntity> findByRangeDateRegister(@Param("start") String start, @Param("end") String end);
}
