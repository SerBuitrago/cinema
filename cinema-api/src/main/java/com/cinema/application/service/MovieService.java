package com.cinema.application.service;

import com.cinema.application.repository.MovieRepository;
import com.cinema.dominio.Movie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository movieRepository;

	public Movie findById(Long id) {
		return movieRepository.findById(id);
	}
}
