package com.cinema.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.cinema.application.repository.AuditRepository;
import com.cinema.application.repository.GenderMovieSerieRepository;
import com.cinema.application.repository.GenderRepository;
import com.cinema.application.repository.ImageRepository;
import com.cinema.application.repository.MovieRepository;
import com.cinema.application.service.AuditService;
import com.cinema.application.service.GenderMovieSerieService;
import com.cinema.application.service.GenderService;
import com.cinema.application.service.ImageService;
import com.cinema.application.service.MovieService;

@Configuration
public class CinemaApiService {
	
	@Bean
	public AuditService auditService(AuditRepository auditRepository) {
		return new AuditService(auditRepository);
	}
	
	@Bean
	public GenderMovieSerieService genderMovieSerieService(GenderMovieSerieRepository genderMovieSerieRepository) {
		return new GenderMovieSerieService(genderMovieSerieRepository);
	}
	
	@Bean
	public GenderService genderService(GenderRepository genderRepository) {
		return new GenderService(genderRepository);
	}
	
	@Bean
	public ImageService imageService(ImageRepository imageRepository) {
		return new ImageService(imageRepository);
	}
	
	@Bean
	public MovieService movieService(MovieRepository movieRepository) {
		return new MovieService(movieRepository);
	}
	
	@Bean
    public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
