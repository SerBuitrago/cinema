package com.cinema.application.repository;

import com.cinema.dominio.entity.GenderMovie;

public interface GenderMovieRepository {
	
	GenderMovie findById(Long id);
}
