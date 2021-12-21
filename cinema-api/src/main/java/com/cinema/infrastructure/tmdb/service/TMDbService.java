package com.cinema.infrastructure.tmdb.service;

import java.util.List;

public interface TMDbService<T> {
	
    List<T> fetchMovieList();

    T fetchMovieById(Long id);

    List<T> fetchMoviesBySearchQuery(String query);
}
