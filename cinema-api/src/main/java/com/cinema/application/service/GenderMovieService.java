package com.cinema.application.service;

import com.cinema.application.repository.GenderMovieRepository;
import com.cinema.dominio.entity.GenderMovie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenderMovieService {
	
	private final GenderMovieRepository genderMovieSerieRepository;
	
	public GenderMovie findById(Long id) {
		return genderMovieSerieRepository.findById(id);
	}
}
