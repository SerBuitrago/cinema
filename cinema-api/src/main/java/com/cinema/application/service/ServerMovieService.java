package com.cinema.application.service;

import com.cinema.application.repository.ServerMovieRepository;
import com.cinema.dominio.entity.ServerMovie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerMovieService implements ServerMovieRepository{

	private final ServerMovieRepository serverMovieRepository;

	@Override
	public ServerMovie findById(Long id) {
		return serverMovieRepository.findById(id);
	}
}
