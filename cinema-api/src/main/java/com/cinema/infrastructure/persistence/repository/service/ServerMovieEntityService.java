package com.cinema.infrastructure.persistence.repository.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.ServerMovieRepository;
import com.cinema.dominio.entity.ServerMovie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.ServerMovieEntity;
import com.cinema.infrastructure.persistence.mapper.ServerMovieEntityMapper;
import com.cinema.infrastructure.persistence.repository.ServerMovieEntityRepository;
import com.cinema.infrastructure.util.Cinema;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServerMovieEntityService implements ServerMovieRepository {

	private final ServerMovieEntityRepository serverMovieEntityRepository;
	private final ServerMovieEntityMapper serverMovieEntityMapper;

	@Override
	public ServerMovie findById(Long id) {
		if (!Cinema.isLong(id))
			throw new CinemaException("El id del servidor de la pelicula no es valido.");
		Optional<ServerMovieEntity> optional = serverMovieEntityRepository.findById(id);
		if (!optional.isPresent())
			throw new CinemaException("No se ha encontrado ningun servidor de pelicula con el id " + id + ".");
		return serverMovieEntityMapper.toDomain(optional.orElse(null));
	}
}
