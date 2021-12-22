package com.cinema.application.repository;

import com.cinema.dominio.entity.GenderMovieSerie;

public interface GenderMovieSerieRepository {
	
	GenderMovieSerie findById(Long id);
}
