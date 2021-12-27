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

    /**
     * Movie
     */
    @Value("${tmdb.find.movie.url}")
    private String tmdbFindMovie;
    
    @Value("${tmdb.find.movie.id.url}")
    private String tmdbFindMovieId;
    
    @Value("${tmdb.find.movie.image.url}")
    private String tmdbFindMovieImageId;
    
    /**
     * Serie
     */
    @Value("${tmdb.find.serie.url}")
    private String tmdbFindSerie;
    
    @Value("${tmdb.find.serie.id.url}")
    private String tmdbFindSerieId;
    
    @Value("${tmdb.find.serie.seanson.url}")
    private String tmdbFindSerieSeansonId;
    
    @Value("${tmdb.find.serie.changes.url}")
    private String tmdbFindSerieChangesId;
    
    @Value("${tmdb.find.serie.image.url}")
    private String tmdbFindSerieSeansonImageId;
    
    @Value("${tmdb.find.serie.video.url}")
    private String tmdbFindSerieSeansonVideosId;
    
    /**
     * Gender
     */
    @Value("${tmdb.find.genre.url}")
    private String tmdbFindMovieGenre;
}
