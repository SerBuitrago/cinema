package com.cinema.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cinema.application.repository.MovieRepository;
import com.cinema.application.service.MovieService;

@Configuration
public class CinemaApiService {
	
	@Bean
	public MovieService movieService(MovieRepository movieRepository) {
		return new MovieService(movieRepository);
	}
}
