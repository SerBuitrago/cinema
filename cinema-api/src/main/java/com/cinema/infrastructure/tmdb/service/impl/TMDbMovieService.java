package com.cinema.infrastructure.tmdb.service.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.cinema.infrastructure.tmdb.model.GenderTMDb;
import com.cinema.infrastructure.tmdb.model.GendersTMDb;
import com.cinema.infrastructure.tmdb.model.MovieTMDb;
import com.cinema.infrastructure.tmdb.service.TMDbService;

public class TMDbMovieService implements TMDbService<MovieTMDb>{
	
    @Value("${tmdb-api-key}")
    private String tmdbApiKey;

    @Value("${tmdb.base.url}")
    private String tmdbBaseUrl;

    @Value("${tmdb.find.movie.url}")
    private String tmdbSearchMovieUrl;
    
    @Value("${tmdb.find.movie.id.url}")
    private String tmdbMovieIdUrl;

    @Value("${tmdb.find.genre.url}")
    private String tmdbGenreUrl;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public List<GenderTMDb> genders(){
        UriComponents uriComponents =
                UriComponentsBuilder.fromUriString(tmdbGenreUrl).build()
                        .expand(tmdbBaseUrl, tmdbApiKey)
                        .encode();

        URI uri = uriComponents.toUri();
        GendersTMDb genres = restTemplate.getForObject(uri, GendersTMDb.class);
        return genres.getGendersList();
    }

	@Override
	public List<MovieTMDb> fetchMovieList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieTMDb fetchMovieById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieTMDb> fetchMoviesBySearchQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}
}
