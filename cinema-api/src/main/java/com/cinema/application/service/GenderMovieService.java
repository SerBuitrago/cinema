package com.cinema.application.service;

import java.util.List;

import com.cinema.application.repository.GenderMovieRepository;
import com.cinema.dominio.entity.GenderMovie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenderMovieService implements GenderMovieRepository{
	
	private final GenderMovieRepository genderMovieSerieRepository;
	
	@Override
	public GenderMovie findById(Long id) {
		return genderMovieSerieRepository.findById(id);
	}
	
	@Override
	public GenderMovie findByMovieAndGender(Long idMovie, Long idGender) {
		return genderMovieSerieRepository.findByMovieAndGender(idMovie, idGender);
	}

	@Override
	public List<GenderMovie> findByStatuAll(boolean statu) {
		return genderMovieSerieRepository.findByStatuAll(statu);
	}

	@Override
	public GenderMovie save(GenderMovie genderMovie) {
		return genderMovieSerieRepository.save(genderMovie);
	}

	@Override
	public boolean delete(Long id) {
		return genderMovieSerieRepository.delete(id);
	}
}
