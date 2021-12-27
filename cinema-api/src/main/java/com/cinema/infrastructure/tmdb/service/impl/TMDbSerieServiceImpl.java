package com.cinema.infrastructure.tmdb.service.impl;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.cinema.dominio.tmdb.ImageSerieSeasonTMDb;
import com.cinema.dominio.tmdb.SeasonsTMDb;
import com.cinema.dominio.tmdb.SerieTMDb;
import com.cinema.infrastructure.config.CinemaComponent;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.tmdb.service.TMDbSerieService;

@Service
public class TMDbSerieServiceImpl implements TMDbSerieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TMDbSerieServiceImpl.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CinemaComponent cinemaComponent;

	@Override
	public SerieTMDb findById(Long id) {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString(cinemaComponent.getTmdbFindSerieId()).build()
				.expand(cinemaComponent.getTmdbBaseUrl(), id, cinemaComponent.getTmdbApiKey(),
						cinemaComponent.getTmdbLanguage())
				.encode();
		SerieTMDb serieTMDb = null;
		try {
			URI uri = uriComponents.toUri();
			serieTMDb = restTemplate.getForObject(uri, SerieTMDb.class);
		} catch (Exception e) {
			LOGGER.error("findById(Long id)", e);
		} finally {
			if (serieTMDb == null)
				throw new CinemaException("No se ha encontrado ninguna serie en tmdb con el " + id + ".");
		}
		return serieTMDb;
	}

	@Override
	public SeasonsTMDb findBySerieAndSeanson(Long idSerie, Long idSeason) {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString(cinemaComponent.getTmdbFindSerieSeansonId())
				.build().expand(cinemaComponent.getTmdbBaseUrl(), idSerie, idSeason, cinemaComponent.getTmdbApiKey(),
						cinemaComponent.getTmdbLanguage())
				.encode();
		SeasonsTMDb seasonsTMDb = null;
		try {
			URI uri = uriComponents.toUri();
			seasonsTMDb = restTemplate.getForObject(uri, SeasonsTMDb.class);
		} catch (Exception e) {
			LOGGER.error("findBySerieAndSeanson(Long idSerie, Long idSeason)", e);
		} finally {
			if (seasonsTMDb == null)
				throw new CinemaException("No se ha encontrado ninguna serie en tmdb con el " + idSerie
						+ " y temporada con el id " + idSeason + ".");
		}
		return seasonsTMDb;
	}

	@Override
	public ImageSerieSeasonTMDb findImageBySerieAndSeanson(Long idSerie, Long idSeason) {
		UriComponents uriComponents = UriComponentsBuilder
				.fromUriString(cinemaComponent.getTmdbFindSerieSeansonImageId()).build()
				.expand(cinemaComponent.getTmdbBaseUrl(), idSerie, idSeason, cinemaComponent.getTmdbApiKey(),
						cinemaComponent.getTmdbLanguage())
				.encode();
		ImageSerieSeasonTMDb imageSerieSeasonTMDb = null;
		try {
			URI uri = uriComponents.toUri();
			imageSerieSeasonTMDb = restTemplate.getForObject(uri, ImageSerieSeasonTMDb.class);
		} catch (Exception e) {
			LOGGER.error("findImageBySerieAndSeanson(Long idSerie, Long idSeason)", e);
		} finally {
			if (imageSerieSeasonTMDb == null)
				throw new CinemaException("No se ha encontrado ninguna imagen de la serie en tmdb con el " + idSerie
						+ " y temporada con el id " + idSeason + ".");
		}
		return imageSerieSeasonTMDb;
	}
}
