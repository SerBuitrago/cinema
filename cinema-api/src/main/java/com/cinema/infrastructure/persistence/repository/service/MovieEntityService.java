package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.MovieRepository;
import com.cinema.dominio.Movie;
import com.cinema.infrastructure.config.Cinema;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.MovieEntity;
import com.cinema.infrastructure.persistence.mapper.MovieEntityMapper;
import com.cinema.infrastructure.persistence.repository.MovieRepositoryData;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieEntityService implements MovieRepository {

	private final MovieRepositoryData movieRepositoryData;
	private final MovieEntityMapper movieEntityMapper;

	@Override
	public Movie findById(Long id) {
		if (!Cinema.isLong(id))
			throw new CinemaException("El id de la pelicula no es valido.");
		Optional<MovieEntity> movie = movieRepositoryData.findById(id);
		if (movie == null || !movie.isPresent())
			throw new CinemaException("No se ha encontrado ninguna pelicula con el id " + id + ".");
		return movieEntityMapper.toDomain(movie.orElse(null));
	}

	@Override
	public Movie findByName(String name) {
		if (!Cinema.isString(name))
			throw new CinemaException("El nombre de la pelicula no es valido.");
		MovieEntity movie = movieRepositoryData.findByName(name);
		if (movie == null)
			throw new CinemaException("No se ha encontrado ninguna pelicula con el nombre " + name + ".");
		return movieEntityMapper.toDomain(movie);
	}

	@Override
	public List<Movie> findAll() {
		return movieEntityMapper.toDomainList(movieRepositoryData.findAll());
	}

	@Override
	public List<Movie> findByStatuAll(boolean statu) {
		return movieEntityMapper.toDomainList(movieRepositoryData.findByStatu(statu));
	}

	@Override
	public List<Movie> findByRangeDateRegisterAll(String start, String end) {
		String array[] = Cinema.isRangeDateRegister(start, end);
		return movieEntityMapper.toDomainList(movieRepositoryData.findByRangeDateRegister(array[0], array[1]));
	}

}
