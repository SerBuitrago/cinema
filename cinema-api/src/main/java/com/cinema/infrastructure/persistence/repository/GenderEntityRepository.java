package com.cinema.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.infrastructure.persistence.entity.GenderEntity;

@Repository
public interface GenderEntityRepository extends JpaRepository<GenderEntity, Long> {

	GenderEntity findByName(String name);

	List<GenderEntity> findByStatu(boolean statu);

	@Query(nativeQuery = false, value = "SELECT g FROM GenderEntity g WHERE g.dateRegister BETWEEN :start AND :end ORDER BY g.dateRegister")
	List<GenderEntity> findByRangeDateRegister(@Param("start") String start, @Param("end") String end);
}
