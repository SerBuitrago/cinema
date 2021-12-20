package com.cinema.application.repository;

import com.cinema.dominio.Movie;

public interface MovieRepository {
	
	Movie findById(Long id);
}
