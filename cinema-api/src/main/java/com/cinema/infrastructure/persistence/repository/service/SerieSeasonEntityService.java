package com.cinema.infrastructure.persistence.repository.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.SerieSeasonRepository;
import com.cinema.dominio.entity.SerieSeason;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.SerieSeasonEntity;
import com.cinema.infrastructure.persistence.mapper.SerieSeasonEntityMapper;
import com.cinema.infrastructure.persistence.repository.SerieSeasonEntityRepository;
import com.cinema.infrastructure.util.Cinema;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SerieSeasonEntityService implements SerieSeasonRepository {

	private final SerieSeasonEntityRepository serieSeasonEntityRepository;
	private final SerieSeasonEntityMapper serieSeasonEntityMapper;

	@Override
	public SerieSeason findById(Long id) {
		if (!Cinema.isLong(id))
			throw new CinemaException("El id de la temporada de la serie no es valido.");
		Optional<SerieSeasonEntity> optional = serieSeasonEntityRepository.findById(id);
		if (!optional.isPresent())
			throw new CinemaException("No se ha encontrado ninguna temporada con el id " + id + ".");
		return serieSeasonEntityMapper.toDomain(optional.orElse(null));
	}
}
