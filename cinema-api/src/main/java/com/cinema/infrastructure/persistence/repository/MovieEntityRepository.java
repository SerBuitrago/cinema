package com.cinema.infrastructure.persistence.repository;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.MovieRepository;
import com.cinema.dominio.Movie;
import com.cinema.infrastructure.persistence.mapper.MovieEntityMapper;
import com.cinema.infrastructure.rest.mapper.MovieMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieEntityRepository implements MovieRepository{

	private final MovieRepositoryData movieRepositoryData;
	private final MovieEntityMapper movieEntityMapper;
	
	@Override
	public Movie findById(Long id) {
		return movieEntityMapper.toDomain(movieRepositoryData.findById(id).orElse(null));
	}

}
