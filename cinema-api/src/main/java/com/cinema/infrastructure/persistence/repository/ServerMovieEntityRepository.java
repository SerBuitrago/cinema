package com.cinema.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.infrastructure.persistence.entity.ServerMovieEntity;

@Repository
public interface ServerMovieEntityRepository extends JpaRepository<ServerMovieEntity, Long>{
	
	@Query(nativeQuery = false, value = "SELECT sm FROM ServerMovieEntity sm WHERE sm.idServer = :idServer AND sm.idMovie = :idMovie")
	ServerMovieEntity findByMovieAndServer(@Param("idServer") Long idServer, @Param("idMovie") Long idMovie);

	List<ServerMovieEntity> findByStatu(boolean statu);
	
	@Query(nativeQuery = false, value = "SELECT sm FROM ServerMovieEntity sm WHERE sm.idMovie = :idMovie")
	List<ServerMovieEntity> findByMovieAll(@Param("idMovie") Long idMovie);
	
	@Query(nativeQuery = false, value = "SELECT sm FROM ServerMovieEntity sm WHERE sm.idServer = :idServer")
	List<ServerMovieEntity> findByServerAll(@Param("idServer") Long idServer);
	
	@Query(nativeQuery = false, value = "SELECT sm FROM ServerMovieEntity sm WHERE sm.dateRegister BETWEEN :start AND :end ORDER BY sm.dateRegister")
	List<ServerMovieEntity> findByRangeDateRegister(@Param("start") String start, @Param("end") String end);
}
