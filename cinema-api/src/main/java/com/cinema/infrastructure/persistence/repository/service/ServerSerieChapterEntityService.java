package com.cinema.infrastructure.persistence.repository.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.ServerSerieChapterRepository;
import com.cinema.dominio.entity.ServerSerieChapter;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.ServerSerieChapterEntity;
import com.cinema.infrastructure.persistence.mapper.ServerSerieChapterEntityMapper;
import com.cinema.infrastructure.persistence.repository.ServerSerieChapterEntityRepository;
import com.cinema.infrastructure.util.Cinema;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServerSerieChapterEntityService implements ServerSerieChapterRepository {

	private final ServerSerieChapterEntityRepository serverSerieChapterEntityRepository;
	private final ServerSerieChapterEntityMapper serverSerieChapterEntityMapper;

	@Override
	public ServerSerieChapter findById(Long id) {
		if (!Cinema.isLong(id))
			throw new CinemaException("El id del servidor del capitulo de la serie no es valido.");
		Optional<ServerSerieChapterEntity> optional = serverSerieChapterEntityRepository.findById(id);
		if (!optional.isPresent())
			throw new CinemaException(
					"No se ha encontrado ningun servidor de un capitulo de serie con el id " + id + ".");
		return serverSerieChapterEntityMapper.toDomain(optional.orElse(null));
	}
}
