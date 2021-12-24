package com.cinema.infrastructure.tmdb.service;

import java.util.List;

import com.cinema.dominio.tmdb.GenderTMDb;
import com.cinema.dominio.tmdb.ImageMovieTMDb;
import com.cinema.dominio.tmdb.MovieTMDb;

public interface TMDbMovieService {

    MovieTMDb findById(Long id);
    
    ImageMovieTMDb findImageById(Long id);
    
    List<MovieTMDb> findAll();

    List<MovieTMDb> findByQuery(String query);
    
    List<GenderTMDb> genders();
}
