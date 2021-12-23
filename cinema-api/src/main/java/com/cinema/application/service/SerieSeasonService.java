package com.cinema.application.service;

import com.cinema.application.repository.SerieSeasonRepository;
import com.cinema.dominio.entity.SerieSeason;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SerieSeasonService implements SerieSeasonRepository {

	private final SerieSeasonRepository seasonRepository;

	@Override
	public SerieSeason findById(Long id) {
		return seasonRepository.findById(id);
	}
}
