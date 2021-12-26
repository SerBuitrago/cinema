package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cinema.application.repository.ServerMovieRepository;
import com.cinema.dominio.entity.ServerMovie;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.ServerMovieEntity;
import com.cinema.infrastructure.persistence.entity.validate.ServerMovieEntityValidate;
import com.cinema.infrastructure.persistence.mapper.ServerMovieEntityMapper;
import com.cinema.infrastructure.persistence.repository.ServerMovieEntityRepository;
import com.cinema.infrastructure.util.Cinema;
import com.cinema.infrastructure.util.CinemaAudit;
import com.cinema.infrastructure.util.CinemaDate;

@Service
public class ServerMovieEntityService implements ServerMovieRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServerMovieEntityService.class);

	@Value("${cinema.audit.database}")
	private String CINEMA_AUDIT_DATABASE;

	@Value("${cinema.audit.table.serverMovie}")
	private String CINEMA_AUDIT_TABLE;

	private final ServerMovieEntityRepository serverMovieEntityRepository;
	private final ServerMovieEntityMapper serverMovieEntityMapper;

	private CinemaAudit cinemaAudit;

	@Autowired
	AuditEntityService auditEntityService;

	public ServerMovieEntityService(ServerMovieEntityRepository serverMovieEntityRepository,
			ServerMovieEntityMapper serverMovieEntityMapper) {
		this.serverMovieEntityRepository = serverMovieEntityRepository;
		this.serverMovieEntityMapper = serverMovieEntityMapper;
	}

	@PostConstruct
	public void init() {
		this.cinemaAudit = new CinemaAudit(CINEMA_AUDIT_DATABASE, CINEMA_AUDIT_TABLE, null, "servidor pelicula");
	}

	@Override
	public ServerMovie findById(Long id) {
		auditEntityService.save(cinemaAudit.findById(id));
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
		ServerMovieEntityValidate.validate(serverMovie);
		String message = Cinema.message(type, false);
		serverMovie = !Cinema.isLong(serverMovie.getId()) ? saveToSave(serverMovie, type)
				: saveToUpdate(serverMovie, type);
		ServerMovieEntity serverMovieEntity = serverMovieEntityRepository
				.save(serverMovieEntityMapper.toEntity(serverMovie));
		if (serverMovieEntity == null)
			throw new CinemaException("No se ha " + message + " el servidor de la pelicula.");
		return serverMovieEntityMapper.toDomain(serverMovieEntity);
	}

	@Override
	public boolean delete(Long id) {
		ServerMovie serverMovie = findById(id);
		if (serverMovie.isStatu())
			throw new CinemaException(
					"No se ha eliminado el servidor con id " + id + " de la pelicula, tiene el estado activado.");
		serverMovieEntityRepository.deleteById(id);
		try {
			if (findById(id) == null)
				return true;
		} catch (CinemaException e) {
			LOGGER.error("delete(Long id)", e);
			return true;
		}
		throw new CinemaException("No se ha eliminado el servidor con id " + id + " de la pelicula.");
	}

	private ServerMovie saveToSave(ServerMovie serverMovie, int type) {
		if (!testMovieServer(serverMovie.getIdMovie(), serverMovie.getIdServer()))
			throw new CinemaException("La pelicula con el id " + serverMovie.getIdMovie()
					+ " ya tiene asociado el servidor con el id " + serverMovie.getIdServer() + ".");
		CinemaDate date = new CinemaDate();
		serverMovie.setId(0L);
		serverMovie.setDateRegister(date.currentToDateTime(null));
		serverMovie.setDateUpdate(null);
		serverMovie.setStatu(true);
		return serverMovie;
	}

	private ServerMovie saveToUpdate(ServerMovie serverMovie, int type) {
		ServerMovie aux = null;
		if (type != 3)
			aux = findById(serverMovie.getId());
		Long idMovie = (type != 3 ? aux.getIdMovie() : serverMovie.getIdMovie());
		if (serverMovie.getIdMovie() != idMovie) {
			if (!testMovieServer(serverMovie.getIdMovie(), serverMovie.getIdServer()))
				throw new CinemaException("La pelicula con el id " + serverMovie.getIdMovie()
						+ " ya tiene asociado el servidor con el id " + serverMovie.getIdServer() + ".");
		}
		CinemaDate date = new CinemaDate();
		serverMovie.setDateRegister(type != 3 ? aux.getDateRegister() : serverMovie.getDateRegister());
		serverMovie.setDateUpdate(date.currentToDateTime(null));
		serverMovie.setStatu(type != 3 ? aux.isStatu() : !serverMovie.isStatu());
		return serverMovie;
	}

	private boolean testMovieServer(Long idMovie, Long idServer) {
		ServerMovie serverMovie = null;
		try {
			serverMovie = findByMovieAndServer(idServer, idMovie);
		} catch (CinemaException e) {
			LOGGER.error("testMovieServer(Long idMovie, Long idServer)", e);
		}
		return (serverMovie == null) ? true : false;
	}
}
