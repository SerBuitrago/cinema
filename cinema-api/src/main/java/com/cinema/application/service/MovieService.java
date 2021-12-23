package com.cinema.application.service;

import java.util.List;

import com.cinema.application.repository.MovieRepository;
import com.cinema.dominio.entity.Movie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovieService implements MovieRepository{

	private final MovieRepository movieRepository;
	
	@Override
	public Movie findById(Long id) {
		return movieRepository.findById(id);
	}

	@Override
	public Movie findByName(String name) {
		return movieRepository.findByName(name);
	}

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> findByStatuAll(boolean statu) {
		return movieRepository.findByStatuAll(statu);
	}

	@Override
	public List<Movie> findByRangeDateRegisterAll(String start, String end) {
		return movieRepository.findByRangeDateRegisterAll(start, end);
	}

	@Override
	public Movie save(Movie movie, int type) {
		return movieRepository.save(movie, type);
	}
}
