package com.cinema.infrastructure.tmdb.service.impl;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.cinema.dominio.tmdb.GenderTMDb;
import com.cinema.dominio.tmdb.GendersTMDb;
import com.cinema.dominio.tmdb.MovieTMDb;
import com.cinema.infrastructure.config.CinemaComponent;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.tmdb.service.TMDbMovieService;

@Service
public class TMDbMovieServiceImpl implements TMDbMovieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TMDbMovieServiceImpl.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CinemaComponent cinemaComponent;

	@Override
	public MovieTMDb findById(Long id) {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString(cinemaComponent.getTmdbFindMovieId()).build()
				.expand(cinemaComponent.getTmdbBaseUrl(), id, cinemaComponent.getTmdbApiKey(),
						cinemaComponent.getTmdbLanguage())
				.encode();
		MovieTMDb movie = null;
		try {
			URI uri = uriComponents.toUri();
			movie = restTemplate.getForObject(uri, MovieTMDb.class);
		} catch (Exception e) {
			LOGGER.error("findById(Long id)", e);
		} finally {
			if (movie == null)
				throw new CinemaException("No se ha encontrado ninguna pelicula en tmdb con el " + id + ".");
		}
		return movie;
	}

	@Override
	public List<MovieTMDb> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTMDb> findByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GenderTMDb> genders() {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString(cinemaComponent.getTmdbFindMovieGenre())
				.build().expand(cinemaComponent.getTmdbBaseUrl(), cinemaComponent.getTmdbApiKey(),
						cinemaComponent.getTmdbLanguage())
				.encode();
		URI uri = uriComponents.toUri();
		GendersTMDb genres = restTemplate.getForObject(uri, GendersTMDb.class);
		return genres.getGendersList();
	}
}
