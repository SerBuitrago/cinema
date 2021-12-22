package com.cinema.infrastructure.persistence.repository.service;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.GenderMovieSerieRepository;
import com.cinema.dominio.entity.GenderMovieSerie;
import com.cinema.infrastructure.persistence.mapper.GenderMovieSerieEntityMapper;
import com.cinema.infrastructure.persistence.repository.GenderMovieSerieEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GenderMovieSerieEntityService implements GenderMovieSerieRepository{
	
	private final GenderMovieSerieEntityRepository genderMovieSerieRepositoryData;
	private final GenderMovieSerieEntityMapper genderMovieSerieEntityMapper;
	
	@Override
	public GenderMovieSerie findById(Long id) {
		return genderMovieSerieEntityMapper.toDomain(genderMovieSerieRepositoryData.findById(id).orElse(null));
	}
}
