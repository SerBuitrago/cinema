package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cinema.application.repository.GenderMovieRepository;
import com.cinema.dominio.entity.GenderMovie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.GenderMovieEntity;
import com.cinema.infrastructure.persistence.entity.validate.GenderMovieEntityValidate;
import com.cinema.infrastructure.persistence.mapper.GenderMovieEntityMapper;
import com.cinema.infrastructure.persistence.repository.GenderMovieEntityRepository;
import com.cinema.infrastructure.util.Cinema;
import com.cinema.infrastructure.util.CinemaDate;

@Service
public class GenderMovieEntityService implements GenderMovieRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenderMovieEntityService.class);

	private final GenderMovieEntityRepository genderMovieSerieEntityRepository;
	private final GenderMovieEntityMapper genderMovieEntityMapper;

	public GenderMovieEntityService(GenderMovieEntityRepository genderMovieSerieEntityRepository,
			GenderMovieEntityMapper genderMovieEntityMapper) {
		this.genderMovieSerieEntityRepository = genderMovieSerieEntityRepository;
		this.genderMovieEntityMapper = genderMovieEntityMapper;
	}

	@Override
	public GenderMovie findById(Long id) {
		return genderMovieEntityMapper.toDomain(genderMovieSerieEntityRepository.findById(id).orElse(null));
	}

	@Override
	public GenderMovie findByMovieAndGender(Long idMovie, Long idGender) {
		if (!Cinema.isLong(idMovie))
			throw new CinemaException("El id de la pelicula no es valido.");
		if (!Cinema.isLong(idGender))
			throw new CinemaException("El id del genero no es valido.");
		GenderMovieEntity genderMovieEntity = genderMovieSerieEntityRepository.findByMovieAndGender(idMovie, idGender);
		if (genderMovieEntity == null)
			throw new CinemaException("No se ha encontrado ningun resultado con el id de pelicula " + idMovie
					+ " y el id del genero " + idGender + ".");
		return genderMovieEntityMapper.toDomain(genderMovieEntity);
	}

	@Override
	public List<GenderMovie> findByStatuAll(boolean statu) {
		return genderMovieEntityMapper.toDomainList(genderMovieSerieEntityRepository.findByStatu(statu));
	}

	@Override
	public GenderMovie save(GenderMovie genderMovie) {
		GenderMovieEntityValidate.validate(genderMovie);
		if (!testMovieGender(genderMovie.getIdMovie(), genderMovie.getIdMovie()))
			throw new CinemaException("Ya se ha registrado el genero con id " + genderMovie.getIdGender()
					+ " a la pelicula con id " + genderMovie.getIdMovie() + ".");
		CinemaDate date = new CinemaDate();
		genderMovie.setDateRegister(date.currentToDateTime(null));
		genderMovie.setStatu(true);
		GenderMovieEntity genderMovieEntity = genderMovieSerieEntityRepository
				.save(genderMovieEntityMapper.toEntity(genderMovie));
		if(genderMovieEntity == null)
			throw new CinemaException("No se ha registrado el genero con id " + genderMovie.getIdGender()+ 
					" a la pelicula con id " + genderMovie.getIdMovie() + ".");
		return genderMovieEntityMapper.toDomain(genderMovieEntity);
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	private boolean testMovieGender(Long idMovie, Long idGender) {
		GenderMovie genderMovie = null;
		try {
			genderMovie = findByMovieAndGender(idMovie, idGender);
		} catch (CinemaException e) {
			LOGGER.error("testMovieGender(Long idMovie, Long idGender)", e);
		}
		return (genderMovie == null) ? true : false;
	}
}
