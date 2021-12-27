package com.cinema.infrastructure.tmdb.service;

import com.cinema.dominio.tmdb.ImageSerieSeasonTMDb;
import com.cinema.dominio.tmdb.SeasonsTMDb;
import com.cinema.dominio.tmdb.SerieTMDb;

public interface TMDbSerieService {

	SerieTMDb findById(Long id);
	
	SeasonsTMDb findBySerieAndSeanson(Long idSerie, Long idSeason);
	
	ImageSerieSeasonTMDb findImageBySerieAndSeanson(Long idSerie, Long idSeason);
}
