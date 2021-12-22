package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.application.repository.MovieRepository;
import com.cinema.dominio.entity.Movie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.MovieEntity;
import com.cinema.infrastructure.persistence.mapper.MovieEntityMapper;
import com.cinema.infrastructure.persistence.repository.MovieRepositoryData;
import com.cinema.infrastructure.tmdb.service.impl.TMDbMovieServiceImpl;
import com.cinema.infrastructure.util.Cinema;

@Service
public class MovieEntityService implements MovieRepository {

	private final MovieRepositoryData movieRepositoryData;
	private final MovieEntityMapper movieEntityMapper;
	
	@Autowired
	TMDbMovieServiceImpl tmDbMovieService;
	
	public MovieEntityService(MovieRepositoryData movieRepositoryData, MovieEntityMapper movieEntityMapper) {
		this.movieRepositoryData = movieRepositoryData;
		this.movieEntityMapper = movieEntityMapper;
	}
	
	@Override
	public Movie findById(Long id) {
		if (!Cinema.isLong(id))
			throw new CinemaException("El id de la pelicula no es valido.");
		Optional<MovieEntity> optional = movieRepositoryData.findById(id);
		if (optional == null || !optional.isPresent())
			throw new CinemaException("No se ha encontrado ninguna pelicula con el id " + id + ".");
		MovieEntity movie = optional.orElse(null);
		movie.setMovieTMDb(tmDbMovieService.findById(id));
		return movieEntityMapper.toDomain(movie);
	}

	@Override
	public Movie findByName(String name) {
		if (!Cinema.isString(name))
			throw new CinemaException("El nombre de la pelicula no es valido.");
		MovieEntity movie = movieRepositoryData.findByName(name);
		if (movie == null)
			throw new CinemaException("No se ha encontrado ninguna pelicula con el nombre " + name + ".");
		movie.setMovieTMDb(tmDbMovieService.findById(movie.getId()));
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
