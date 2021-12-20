package com.cinema.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.infrastructure.persistence.entity.MovieEntity;

@Repository
public interface MovieRepositoryData  extends JpaRepository<MovieEntity, Long>{

}
