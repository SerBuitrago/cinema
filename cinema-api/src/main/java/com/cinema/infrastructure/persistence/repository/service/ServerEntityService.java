package com.cinema.infrastructure.persistence.repository.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.ServerRepository;
import com.cinema.dominio.entity.Server;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.ServerEntity;
import com.cinema.infrastructure.persistence.mapper.ServerEntityMapper;
import com.cinema.infrastructure.persistence.repository.ServerEntityRepository;
import com.cinema.infrastructure.util.Cinema;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServerEntityService implements ServerRepository {

	private final ServerEntityRepository serverEntityRepository;
	private final ServerEntityMapper serverEntityMapper;

	@Override
	public Server findById(Long id) {
		if (!Cinema.isLong(id))
			throw new CinemaException("El id del servidor no es valido.");
		Optional<ServerEntity> optional = serverEntityRepository.findById(id);
		if (!optional.isPresent())
			throw new CinemaException("No se ha encontrado ningun servidor con el id " + id + ".");
		return serverEntityMapper.toDomain(optional.orElse(null));
	}
}
