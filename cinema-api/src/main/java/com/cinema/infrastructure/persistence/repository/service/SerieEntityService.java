package com.cinema.infrastructure.persistence.repository.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.SerieRepository;
import com.cinema.dominio.entity.Serie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.SerieEntity;
import com.cinema.infrastructure.persistence.mapper.SerieEntityMapper;
import com.cinema.infrastructure.persistence.repository.SerieEntityRepository;
import com.cinema.infrastructure.util.Cinema;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SerieEntityService implements SerieRepository {

	private final SerieEntityRepository serieEntityRepository;
	private final SerieEntityMapper serieEntityMapper;

	@Override
	public Serie findById(Long id) {
		if (!Cinema.isLong(id))
			throw new CinemaException("El id de la serie no es valido.");
		Optional<SerieEntity> optional = serieEntityRepository.findById(id);
		if (!optional.isPresent())
			throw new CinemaException("No se ha encontrado ninguna serie con el id " + id + ".");
		return serieEntityMapper.toDomain(optional.orElse(null));
	}
}
