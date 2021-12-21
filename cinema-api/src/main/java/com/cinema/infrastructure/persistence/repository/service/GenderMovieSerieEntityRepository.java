package com.cinema.infrastructure.persistence.repository.service;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.GenderMovieSerieRepository;
import com.cinema.dominio.GenderMovieSerie;
import com.cinema.infrastructure.persistence.mapper.GenderMovieSerieEntityMapper;
import com.cinema.infrastructure.persistence.repository.GenderMovieSerieRepositoryData;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GenderMovieSerieEntityRepository implements GenderMovieSerieRepository{
	
	private final GenderMovieSerieRepositoryData genderMovieSerieRepositoryData;
	private final GenderMovieSerieEntityMapper genderMovieSerieEntityMapper;
	
	@Override
	public GenderMovieSerie findById(Long id) {
		return genderMovieSerieEntityMapper.toDomain(genderMovieSerieRepositoryData.findById(id).orElse(null));
	}
}
