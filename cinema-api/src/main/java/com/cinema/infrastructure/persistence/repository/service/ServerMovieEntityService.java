package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.ServerMovieRepository;
import com.cinema.dominio.entity.ServerMovie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.ServerMovieEntity;
import com.cinema.infrastructure.persistence.mapper.ServerMovieEntityMapper;
import com.cinema.infrastructure.persistence.repository.ServerMovieEntityRepository;
import com.cinema.infrastructure.util.Cinema;

@Service
public class ServerMovieEntityService implements ServerMovieRepository {

	private final ServerMovieEntityRepository serverMovieEntityRepository;
	private final ServerMovieEntityMapper serverMovieEntityMapper;

	public ServerMovieEntityService(ServerMovieEntityRepository serverMovieEntityRepository,
			ServerMovieEntityMapper serverMovieEntityMapper) {
		this.serverMovieEntityRepository = serverMovieEntityRepository;
		this.serverMovieEntityMapper = serverMovieEntityMapper;
	}

	@Override
	public ServerMovie findById(Long id) {
		if (!Cinema.isLong(id))
			throw new CinemaException("El id del servidor de la pelicula no es valido.");
		Optional<ServerMovieEntity> optional = serverMovieEntityRepository.findById(id);
		if (!optional.isPresent())
			throw new CinemaException("No se ha encontrado ningun servidor de pelicula con el id " + id + ".");
		return serverMovieEntityMapper.toDomain(optional.orElse(null));
	}

	@Override
	public ServerMovie findByMovieAndServer(Long idServer, Long idMovie) {
		if (!Cinema.isLong(idServer))
			throw new CinemaException("El id del servidor no es valido.");
		if (!Cinema.isLong(idMovie))
			throw new CinemaException("El id de la pelicula no es valido.");
		ServerMovieEntity serverMovieEntity = serverMovieEntityRepository.findByMovieAndServer(idServer, idMovie);
		if (serverMovieEntity == null)
			throw new CinemaException("No se ha encontrado ningun resultado con el servidor id " + idServer
					+ " y la pelicula con el id " + idMovie + ".");
		return serverMovieEntityMapper.toDomain(serverMovieEntity);
	}

	@Override
	public List<ServerMovie> findAll() {
		return serverMovieEntityMapper.toDomainList(serverMovieEntityRepository.findAll());
	}

	@Override
	public List<ServerMovie> findByMovieAll(Long idMovie) {
		return serverMovieEntityMapper.toDomainList(serverMovieEntityRepository.findByMovieAll(idMovie));
	}

	@Override
	public List<ServerMovie> findByServerAll(Long idServer) {
		return serverMovieEntityMapper.toDomainList(serverMovieEntityRepository.findByServerAll(idServer));
	}

	@Override
	public List<ServerMovie> findByStatuAll(boolean statu) {
		return serverMovieEntityMapper.toDomainList(serverMovieEntityRepository.findByStatu(statu));
	}

	@Override
	public List<ServerMovie> findByRangeDateRegisterAll(String start, String end) {
		String array[] = Cinema.isRangeDateRegister(start, end);
		return serverMovieEntityMapper
				.toDomainList(serverMovieEntityRepository.findByRangeDateRegister(array[0], array[1]));
	}

	@Override
	public ServerMovie save(ServerMovie serverMovie, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
