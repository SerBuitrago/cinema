package com.cinema.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.cinema.application.repository.AuditRepository;
import com.cinema.application.repository.GenderMovieRepository;
import com.cinema.application.repository.GenderRepository;
import com.cinema.application.repository.ImageRepository;
import com.cinema.application.repository.MovieRepository;
import com.cinema.application.repository.SerieChapterRepository;
import com.cinema.application.repository.SerieRepository;
import com.cinema.application.repository.SerieSeasonRepository;
import com.cinema.application.repository.ServerMovieRepository;
import com.cinema.application.repository.ServerRepository;
import com.cinema.application.repository.ServerSerieChapterRepository;
import com.cinema.application.service.AuditService;
import com.cinema.application.service.GenderMovieService;
import com.cinema.application.service.GenderService;
import com.cinema.application.service.ImageService;
import com.cinema.application.service.MovieService;
import com.cinema.application.service.SerieChapterService;
import com.cinema.application.service.SerieSeasonService;
import com.cinema.application.service.SerieService;
import com.cinema.application.service.ServerMovieService;
import com.cinema.application.service.ServerSerieChapterService;
import com.cinema.application.service.ServerService;

@Configuration
public class CinemaApiService {
	
	@Bean
	public AuditService auditService(AuditRepository auditRepository) {
		return new AuditService(auditRepository);
	}
	
	@Bean
	public GenderMovieService genderMovieService(GenderMovieRepository genderMovieRepository) {
		return new GenderMovieService(genderMovieRepository);
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
	public SerieChapterService serieChapterService(SerieChapterRepository serieChapterRepository) {
		return new SerieChapterService(serieChapterRepository);
	}
	
	@Bean
	public SerieSeasonService serieSeasonService(SerieSeasonRepository serieSeasonRepository) {
		return new SerieSeasonService(serieSeasonRepository);
	}
	
	@Bean
	public SerieService serieService(SerieRepository serieRepository) {
		return new SerieService(serieRepository);
	}
	
	@Bean
	public ServerMovieService serverMovieService(ServerMovieRepository serverMovieRepository) {
		return new ServerMovieService(serverMovieRepository);
	}
	
	@Bean
	public ServerSerieChapterService serverSerieChapterService(ServerSerieChapterRepository serverSerieChapterRepository) {
		return new ServerSerieChapterService(serverSerieChapterRepository);
	}
	
	@Bean
	public ServerService serverService(ServerRepository serverRepository) {
		return new ServerService(serverRepository);
	}
	
	@Bean
    public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
