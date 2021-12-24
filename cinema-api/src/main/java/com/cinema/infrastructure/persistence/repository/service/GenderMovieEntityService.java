package com.cinema.infrastructure.persistence.repository.service;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.GenderMovieRepository;
import com.cinema.dominio.entity.GenderMovie;
import com.cinema.infrastructure.persistence.mapper.GenderMovieEntityMapper;
import com.cinema.infrastructure.persistence.repository.GenderMovieSerieEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GenderMovieEntityService implements GenderMovieRepository{
	
	private final GenderMovieSerieEntityRepository genderMovieSerieRepositoryData;
	private final GenderMovieEntityMapper genderMovieSerieEntityMapper;
	
	@Override
	public GenderMovie findById(Long id) {
		return genderMovieSerieEntityMapper.toDomain(genderMovieSerieRepositoryData.findById(id).orElse(null));
	}
}
