package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cinema.application.repository.GenderRepository;
import com.cinema.dominio.entity.Gender;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.GenderEntity;
import com.cinema.infrastructure.persistence.entity.validate.GenderEntityValidate;
import com.cinema.infrastructure.persistence.mapper.GenderEntityMapper;
import com.cinema.infrastructure.persistence.repository.GenderEntityRepository;
import com.cinema.infrastructure.util.Cinema;
import com.cinema.infrastructure.util.CinemaAudit;
import com.cinema.infrastructure.util.CinemaDate;

@Service
public class GenderEntityService implements GenderRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenderEntityService.class);

	@Value("${cinema.audit.database}")
	private String CINEMA_AUDIT_DATABASE;

	@Value("${cinema.audit.table.gender}")
	private String CINEMA_AUDIT_TABLE;

	private final GenderEntityRepository genderEntityRepository;
	private final GenderEntityMapper genderEntityMapper;

	private CinemaAudit cinemaAudit;

	@Autowired
	AuditEntityService auditEntityService;

	public GenderEntityService(GenderEntityRepository genderEntityRepository, GenderEntityMapper genderEntityMapper) {
		this.genderEntityRepository = genderEntityRepository;
		this.genderEntityMapper = genderEntityMapper;
	}

	@PostConstruct
	public void init() {
		cinemaAudit = new CinemaAudit(CINEMA_AUDIT_DATABASE, CINEMA_AUDIT_TABLE, null, "genero");
	}

	@Override
	public Gender findById(Long id) {
		auditEntityService.save(cinemaAudit.findById(id));
		if (!Cinema.isLong(id))
			throw new CinemaException("El id del genero no es valido.");
		Optional<GenderEntity> optional = genderEntityRepository.findById(id);
		if (optional == null || !optional.isPresent())
			throw new CinemaException("No se ha encontrado ningun genero con el id " + id + ".");
		GenderEntity genderEntity = optional.orElse(null);
		return genderEntityMapper.toDomain(genderEntity);
	}

	@Override
	public Gender findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gender> findAll() {
		return genderEntityMapper.toDomainList(genderEntityRepository.findAll());
	}

	@Override
	public List<Gender> findByStatuAll(boolean statu) {
		return genderEntityMapper.toDomainList(genderEntityRepository.findByStatu(statu));
	}

	@Override
	public List<Gender> findByRangeDateRegisterAll(String start, String end) {
		String array[] = Cinema.isRangeDateRegister(start, end);
		return genderEntityMapper.toDomainList(genderEntityRepository.findByRangeDateRegister(array[0], array[1]));
	}

	@Override
	public Gender save(Gender gender) {
		GenderEntityValidate.validateName(gender);
		if (!testId(gender.getId()))
			throw new CinemaException("Ya se encuentra registrado un genero con el id " + gender.getId() + ".");
		CinemaDate date = new CinemaDate();
		gender.setDateRegister(date.currentToDateTime(null));
		gender.setDateUpdate(null);
		gender.setStatu(true);
		GenderEntity genderEntity = genderEntityRepository.save(genderEntityMapper.toEntity(gender));
		if (genderEntity == null)
			throw new CinemaException("No se ha registrado el genero.");
		return genderEntityMapper.toDomain(genderEntity);
	}

	private boolean testId(Long id) {
		Gender gender = null;
		try {
			gender = findById(id);
		} catch (CinemaException e) {
			LOGGER.error("testId(Long id)", e);
		}
		return (gender == null) ? true : false;
	}
}
