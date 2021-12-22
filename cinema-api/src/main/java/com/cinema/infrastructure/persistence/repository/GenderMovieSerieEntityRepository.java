package com.cinema.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.infrastructure.persistence.entity.GenderMovieSerieEntity;

@Repository
public interface GenderMovieSerieEntityRepository extends JpaRepository<GenderMovieSerieEntity, Long>{

}
