package com.cinema.application.service;

import com.cinema.application.repository.GenderMovieSerieRepository;
import com.cinema.dominio.GenderMovieSerie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenderMovieSerieService {
	
	private final GenderMovieSerieRepository genderMovieSerieRepository;
	
	public GenderMovieSerie findById(Long id) {
		return genderMovieSerieRepository.findById(id);
	}
}
