package com.cinema.infrastructure.persistence.repository.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.SerieChapterRepository;
import com.cinema.dominio.entity.SerieChapter;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.SerieChapterEntity;
import com.cinema.infrastructure.persistence.mapper.SerieChapterEntityMapper;
import com.cinema.infrastructure.persistence.repository.SerieChapterEntityRepository;
import com.cinema.infrastructure.util.Cinema;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SerieChapterEntityService implements SerieChapterRepository {

	private final SerieChapterEntityRepository serieChapterEntityRepository;
	private final SerieChapterEntityMapper serieChapterEntityMapper;
	
	@Override
	public SerieChapter findById(Long id) {
		if (!Cinema.isLong(id))
			throw new CinemaException("El id del capitulo de la temporada no es valido.");
		Optional<SerieChapterEntity> optional = serieChapterEntityRepository.findById(id);
		if (!optional.isPresent())
			throw new CinemaException("No se ha encontrado ninguna capitulo con el id " + id + ".");
		return serieChapterEntityMapper.toDomain(optional.orElse(null));
	}
}
