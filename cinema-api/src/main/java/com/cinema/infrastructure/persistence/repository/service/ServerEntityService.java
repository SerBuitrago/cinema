package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cinema.application.repository.ServerRepository;
import com.cinema.dominio.entity.Server;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.ServerEntity;
import com.cinema.infrastructure.persistence.entity.validate.ServerEntityValidate;
import com.cinema.infrastructure.persistence.mapper.ServerEntityMapper;
import com.cinema.infrastructure.persistence.repository.ServerEntityRepository;
import com.cinema.infrastructure.util.Cinema;
import com.cinema.infrastructure.util.CinemaAudit;
import com.cinema.infrastructure.util.CinemaDate;

@Service
public class ServerEntityService implements ServerRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServerEntityService.class);

	@Value("${cinema.audit.database}")
	private String CINEMA_AUDIT_DATABASE;

	@Value("${cinema.audit.table.server}")
	private String CINEMA_AUDIT_TABLE;

	private CinemaAudit cinemaAudit;

	@Autowired
	AuditEntityService auditEntityService;

	private final ServerEntityRepository serverEntityRepository;
	private final ServerEntityMapper serverEntityMapper;

	public ServerEntityService(ServerEntityRepository serverEntityRepository, ServerEntityMapper serverEntityMapper) {
		this.serverEntityRepository = serverEntityRepository;
		this.serverEntityMapper = serverEntityMapper;
	}

	@PostConstruct
	public void init() {
		this.cinemaAudit = new CinemaAudit(CINEMA_AUDIT_DATABASE, CINEMA_AUDIT_TABLE, null, "servidor");
	}

	@Override
	public Server findById(Long id) {
		auditEntityService.save(cinemaAudit.findById(id));
		if (!Cinema.isLong(id))
			throw new CinemaException("El id del servidor no es valido.");
		Optional<ServerEntity> optional = serverEntityRepository.findById(id);
		if (!optional.isPresent())
			throw new CinemaException("No se ha encontrado ningun servidor con el id " + id + ".");
		return serverEntityMapper.toDomain(optional.orElse(null));
	}

	@Override
	public Server findByName(String name) {
		if (!Cinema.isString(name))
			throw new CinemaException("El nombre del servidor no es valido.");
		ServerEntity serverEntity = serverEntityRepository.findByName(name);
		if (serverEntity == null)
			throw new CinemaException("No se ha encontrado ningun servidor con el nombre " + name + ".");
		return serverEntityMapper.toDomain(serverEntity);
	}

	@Override
	public List<Server> findAll() {
		return serverEntityMapper.toDomainList(serverEntityRepository.findAll());
	}

	@Override
	public List<Server> findByStatuAll(boolean statu) {
		return serverEntityMapper.toDomainList(serverEntityRepository.findByStatu(statu));
	}

	@Override
	public List<Server> findByRangeDateRegisterAll(String start, String end) {
		String array[] = Cinema.isRangeDateRegister(start, end);
		return serverEntityMapper.toDomainList(serverEntityRepository.findByRangeDateRegister(array[0], array[1]));
	}

	@Override
	public Server save(Server server, int type) {
		ServerEntityValidate.validate(server);
		String message = Cinema.message(type, false);
		server = !Cinema.isLong(server.getId()) ? saveToSave(server, type) : saveToUpdate(server, type);
		ServerEntity serverEntity = serverEntityRepository.save(serverEntityMapper.toEntity(server));
		if (serverEntity == null)
			throw new CinemaException("No se ha " + message + " el servidor.");
		return serverEntityMapper.toDomain(serverEntity);
	}

	@Override
	public boolean delete(Long id) {
		Server server = findById(id);
		if (!server.isStatu())
			throw new CinemaException("No se ha eliminado el servidor, tiene el estado activo.");
		serverEntityRepository.deleteById(id);
		try {
			if (findById(id) == null)
				return true;
		} catch (CinemaException e) {
			LOGGER.error("delete(Long id)", e);
			return true;
		}
		throw new CinemaException("No se ha eliminado el servidor con el id " + id + ".");
	}

	private Server saveToSave(Server server, int type) {
		if (!testName(server.getName()))
			throw new CinemaException("Ya existe un servidor con el nombre " + server.getName() + ".");
		CinemaDate date = new CinemaDate();
		server.setId(0L);
		server.setDateRegister(date.currentToDateTime(null));
		server.setStatu(true);
		server.setDateUpdate(null);
		return server;
	}

	private Server saveToUpdate(Server server, int type) {
		Server aux = null;
		if (type != 3)
			aux = findById(server.getId());
		aux = findById(server.getId());
		if (!validatName(server.getName(), type == 2 ? aux.getName() : server.getName()))
			throw new CinemaException("Ya existe un servidor con el nombre " + server.getName() + ".");
		CinemaDate date = new CinemaDate();
		server.setDateRegister(type != 3 ? aux.getDateRegister() : server.getDateRegister());
		server.setDateUpdate(date.currentToDateTime(null));
		server.setStatu(type != 3 ? aux.isStatu() : !server.isStatu());
		return server;
	}

	private boolean testName(String name) {
		Server server = null;
		try {
			server = findByName(name);
		} catch (CinemaException e) {
			LOGGER.error("testName()", e);
		}
		return (server == null) ? true : false;
	}

	private boolean validatName(String nameA, String nameB) {
		return (!nameA.equalsIgnoreCase(nameB)) ? testName(nameA) : true;
	}
}
