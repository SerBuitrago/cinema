package com.cinema.application.repository;

import com.cinema.dominio.entity.ServerMovie;

public interface ServerMovieRepository {

	ServerMovie findById(Long id);
}
