package com.cinema.infrastructure.persistence.repository.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.cinema.infrastructure.model.GenderModel;
import com.cinema.infrastructure.model.GendersModel;

public class TMDbService {
	
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
    
    public List<GenderModel> genders(){
        UriComponents uriComponents =
                UriComponentsBuilder.fromUriString(tmdbGenreUrl).build()
                        .expand(tmdbBaseUrl, tmdbApiKey)
                        .encode();

        URI uri = uriComponents.toUri();
        GendersModel genres = restTemplate.getForObject(uri, GendersModel.class);
        return genres.getGendersList();
    }
}
