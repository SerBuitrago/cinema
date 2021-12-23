package com.cinema.application.service;

import com.cinema.application.repository.SerieRepository;
import com.cinema.dominio.entity.Serie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SerieService implements SerieRepository{
	
	private final SerieRepository serieRepository;
	
	@Override
	public Serie findById(Long id) {
		return serieRepository.findById(id);
	}

}
