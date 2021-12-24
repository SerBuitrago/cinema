package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cinema.application.repository.MovieRepository;
import com.cinema.dominio.entity.Gender;
import com.cinema.dominio.entity.GenderMovie;
import com.cinema.dominio.entity.Movie;
import com.cinema.dominio.tmdb.GenderTMDb;
import com.cinema.dominio.tmdb.MovieTMDb;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.MovieEntity;
import com.cinema.infrastructure.persistence.entity.validate.MovieEntityValidate;
import com.cinema.infrastructure.persistence.mapper.MovieEntityMapper;
import com.cinema.infrastructure.persistence.repository.MovieEntityRepository;
import com.cinema.infrastructure.tmdb.service.impl.TMDbMovieServiceImpl;
import com.cinema.infrastructure.util.Cinema;
import com.cinema.infrastructure.util.CinemaAudit;
import com.cinema.infrastructure.util.CinemaDate;

@Service
public class MovieEntityService implements MovieRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieEntityService.class);

	@Value("${cinema.audit.database}")
	private String CINEMA_AUDIT_DATABASE;

	@Value("${cinema.audit.table.movie}")
	private String CINEMA_AUDIT_TABLE;
	
	@Value("${tmdb.base.image.original}")
	private String CINEMA_TMDB_IMAGE_URL;

	private CinemaAudit cinemaAudit;
	private MovieTMDb movieTMDb;

	private final MovieEntityRepository movieEntityRepository;
	private final MovieEntityMapper movieEntityMapper;

	@Autowired
	TMDbMovieServiceImpl tmDbMovieService;

	@Autowired
	AuditEntityService auditEntityService;
	
	@Autowired
	GenderEntityService genderEntityService;
	
	@Autowired
	GenderMovieEntityService genderMovieEntityService;

	public MovieEntityService(MovieEntityRepository movieEntityRepository, MovieEntityMapper movieEntityMapper) {
		this.movieEntityRepository = movieEntityRepository;
		this.movieEntityMapper = movieEntityMapper;
	}

	@PostConstruct
	public void init() {
		this.movieTMDb= null;
		this.cinemaAudit = new CinemaAudit(CINEMA_AUDIT_DATABASE, CINEMA_AUDIT_TABLE, null, "pelicula");
	}

	@Override
	public Movie findById(Long id) {
		auditEntityService.save(cinemaAudit.findById(id));
		if (!Cinema.isLong(id))
			throw new CinemaException("El id de la pelicula no es valido.");
		Optional<MovieEntity> optional = movieEntityRepository.findById(id);
		if (optional == null || !optional.isPresent())
			throw new CinemaException("No se ha encontrado ninguna pelicula con el id " + id + ".");
		MovieEntity movie = optional.orElse(null);
		movie.setMovieTMDb(tmDbMovieService.findById(id));
		return movieEntityMapper.toDomain(movie);
	}

	@Override
	public Movie findByName(String name) {
		if (!Cinema.isString(name))
			throw new CinemaException("El nombre de la pelicula no es valido.");
		MovieEntity movie = movieEntityRepository.findByName(name);
		if (movie == null)
			throw new CinemaException("No se ha encontrado ninguna pelicula con el nombre " + name + ".");
		movie.setMovieTMDb(tmDbMovieService.findById(movie.getId()));
		return movieEntityMapper.toDomain(movie);
	}

	@Override
	public List<Movie> findAll() {
		return movieEntityMapper.toDomainList(movieEntityRepository.findAll());
	}

	@Override
	public List<Movie> findByStatuAll(boolean statu) {
		return movieEntityMapper.toDomainList(movieEntityRepository.findByStatu(statu));
	}

	@Override
	public List<Movie> findByRangeDateRegisterAll(String start, String end) {
		String array[] = Cinema.isRangeDateRegister(start, end);
		return movieEntityMapper.toDomainList(movieEntityRepository.findByRangeDateRegister(array[0], array[1]));
	}

	@Override
	public Movie save(Movie movie, int type) {
		MovieEntityValidate.validate(movie);
		String message = Cinema.message(type, false);
		MovieEntity movieEntity = movieEntityMapper
				.toEntity(type == 1 ? saveToSave(movie, type) : saveToUpdate(movie, type));
		movieEntity = movieEntityRepository.save(movieEntity);
		if (movieEntity == null)
			throw new CinemaException("No se ha " + message + " la pelicula.");
		movie = movieEntityMapper.toDomain(movieEntity);
		saveToSaveGenders(movie);
		return movie;
	}

	private Movie saveToSave(Movie movie, int type) {
		if (!testId(movie.getId()))
			throw new CinemaException("Ya existe una pelicula registrada con el id " + movie.getId() + ".");
		CinemaDate date = new CinemaDate();
		movie.setDateRegister(date.currentToDateTime(null));
		movie.setStatu(true);
		movie.setDateUpdate(null);
		return findTmdbById(movie, true);
	}

	private Movie saveToUpdate(Movie movie, int type) {
		Movie aux = null;
		if (type != 3)
			aux = findById(movie.getId());
		CinemaDate date = new CinemaDate();
		movie.setDateUpdate(date.currentToDateTime(null));
		movie.setDateRegister(type == 3 ? movie.getDateRegister() : aux.getDateRegister());
		movie.setStatu(type == 3 ? !movie.isStatu() : aux.isStatu());
		return type == 3 ? movie : findTmdbById(movie, false);
	}

	private Movie findTmdbById(Movie movie, boolean registerGender) {
		this.movieTMDb = tmDbMovieService.findById(movie.getId());
		movie.setName(movieTMDb.getTitle());
		movie.setDescription(movieTMDb.getOverview());
		movie.setAverage(movieTMDb.getVoteAverage());
		movie.setPoster(CINEMA_TMDB_IMAGE_URL+movieTMDb.getPosterPath());
		movie.setBackdrop(CINEMA_TMDB_IMAGE_URL+movieTMDb.getBackdropPath());
		if(!registerGender)
			return movie;
		return movie;
	}
	
	private Movie saveToSaveGenders(Movie movie) {
		if(this.movieTMDb != null && !Cinema.isList(this.movieTMDb.getGenres()))
			return movie;
		for(GenderTMDb gender: this.movieTMDb.getGenres()) {
			Long id = Long.parseLong(String.valueOf(gender.getId()));
			try {
				genderEntityService.save(new Gender(id, gender.getName()));
			}catch (CinemaException e) {
				LOGGER.error("saveToSaveGenders(Movie movie)", e);
			}finally {
				saveToSaveGendersMovie(movie.getId(), id);
			}
		}
		return movie;
	}
	
	private GenderMovie saveToSaveGendersMovie(Long idMovie, Long idGender) {
		GenderMovie genderMovie= null;
		try {
			genderMovie = genderMovieEntityService.save(new GenderMovie(idMovie, idGender));
		}catch (CinemaException e) {
			LOGGER.error("saveToSaveGenders(Movie movie)", e);
		}
		return genderMovie;
	}

	private boolean testId(Long id) {
		Movie movie = null;
		try {
			movie = findById(id);
		} catch (CinemaException e) {
			LOGGER.error("testId(Long id)", e);
		}
		return (movie == null) ? true : false;
	}
}
