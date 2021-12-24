package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.ImageMovieRepository;
import com.cinema.dominio.entity.ImageMovie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.ImageMovieEntity;
import com.cinema.infrastructure.persistence.entity.validate.ImageMovieEntityValidate;
import com.cinema.infrastructure.persistence.mapper.ImageMovieEntityMapper;
import com.cinema.infrastructure.persistence.repository.ImageEntityRepository;
import com.cinema.infrastructure.util.Cinema;
import com.cinema.infrastructure.util.CinemaDate;

@Service
public class ImageMovieEntityService implements ImageMovieRepository {

	private final ImageEntityRepository imageEntityRepository;
	private final ImageMovieEntityMapper imageMovieEntityMapper;

	public ImageMovieEntityService(ImageEntityRepository imageEntityRepository,
			ImageMovieEntityMapper imageMovieEntityMapper) {
		this.imageEntityRepository = imageEntityRepository;
		this.imageMovieEntityMapper = imageMovieEntityMapper;
	}

	@Override
	public ImageMovie findById(Long id) {
		return imageMovieEntityMapper.toDomain(imageEntityRepository.findById(id).orElse(null));
	}

	@Override
	public List<ImageMovie> findByStatuAll(boolean statu) {
		return imageMovieEntityMapper.toDomainList(imageEntityRepository.findAll());
	}

	@Override
	public List<ImageMovie> findByRangeDateRegisterAll(String start, String end) {
		String array[] = Cinema.isRangeDateRegister(start, end);
		return imageMovieEntityMapper.toDomainList(imageEntityRepository.findByRangeDateRegister(array[0], array[1]));
	}

	@Override
	public ImageMovie save(ImageMovie imageMovie) {
		ImageMovieEntityValidate.validate(imageMovie);
		CinemaDate date = new CinemaDate();
		imageMovie.setId(0L);
		imageMovie.setDateUpdate(null);
		imageMovie.setDateRegister(date.currentToDateTime(null));
		imageMovie.setStatu(true);
		ImageMovieEntity imageMovieEntity = imageEntityRepository.save(imageMovieEntityMapper.toEntity(imageMovie));
		if (imageMovieEntity == null)
			throw new CinemaException("No se ha registrado la imagen a la pelicula.");
		return imageMovieEntityMapper.toDomain(imageMovieEntity);
	}
}
