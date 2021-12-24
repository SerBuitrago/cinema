package com.cinema.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CinemaComponent {
	
    @Value("${tmdb.base.url}")
    private String tmdbBaseUrl;
	
	@Value("${tmdb.base.key}")
	private String tmdbApiKey;
    
    @Value("${tmdb.base.language}")
    private String tmdbLanguage;

    @Value("${tmdb.find.movie.url}")
    private String tmdbFindMovie;
    
    @Value("${tmdb.find.movie.id.url}")
    private String tmdbFindMovieId;
    
    @Value("${tmdb.find.movie.image.url}")
    private String tmdbFindMovieImageId;

    @Value("${tmdb.find.genre.url}")
    private String tmdbFindMovieGenre;
}
