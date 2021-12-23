package com.cinema.application.repository;

import com.cinema.dominio.entity.Serie;

public interface SerieRepository {

	Serie findById(Long id);
}
