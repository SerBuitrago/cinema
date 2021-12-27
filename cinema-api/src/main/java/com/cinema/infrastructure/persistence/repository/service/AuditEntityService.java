package com.cinema.infrastructure.persistence.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.AuditRepository;
import com.cinema.dominio.entity.Audit;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.persistence.entity.AuditEntity;
import com.cinema.infrastructure.persistence.entity.validate.AuditEntityValidate;
import com.cinema.infrastructure.persistence.mapper.AuditEntityMapper;
import com.cinema.infrastructure.persistence.repository.AuditEntityRepository;
import com.cinema.infrastructure.util.Cinema;
import com.cinema.infrastructure.util.CinemaDate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuditEntityService implements AuditRepository {

	private final AuditEntityRepository auditEntityRepository;
	private final AuditEntityMapper auditEntityMapper;

	@Override
	public Audit findById(Long id) {
		if (!Cinema.isLong(id))
			throw new CinemaException("El id de la auditoria no es valido.");
		Optional<AuditEntity> optional = auditEntityRepository.findById(id);
		if (!optional.isPresent())
			throw new CinemaException("No se ha encontrado ninguna auditoria con el id " + id + ".");
		return auditEntityMapper.toDomain(optional.orElse(null));
	}

	@Override
	public List<Audit> findAll() {
		return auditEntityMapper.toDomainList(auditEntityRepository.findAll());
	}
	
	@Override
	public List<Audit> findByIdUserAll(Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Audit> findByTableAll(String table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Audit> findByDBAll(String db) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Audit> findByActionAll(String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Audit> findByIpPublicAll(String ipPublic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Audit> findByIpLocalAll(String ipLocal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Audit> findByDBAndTableAll(String db, String table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Audit> findByDBAndTableAndUserAll(String db, String table, Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Audit> findByDBAndTableAndActionAll(String db, String table, String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Audit> findByDBAndTableAndActionAndUserAll(String db, String table, String action, Long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Audit> findByStatuAll(boolean statu) {
		return auditEntityMapper.toDomainList(auditEntityRepository.findByStatu(statu));
	}

	@Override
	public List<Audit> findByRangeDateRegisterAll(String start, String end) {
		String array[] = Cinema.isRangeDateRegister(start, end);
		return auditEntityMapper.toDomainList(auditEntityRepository.findByRangeDateRegister(array[0], array[1]));
	}

	@Override
	public Audit save(Audit audit) {
		AuditEntityValidate.validate(audit);
		CinemaDate date = new CinemaDate();
		audit.setId(0L);
		audit.setIpLocal(!Cinema.isString(audit.getIpLocal()) ? Cinema.getIpLocal() : audit.getIpLocal());
		audit.setIpPublic(!Cinema.isString(audit.getIpPublic()) ? Cinema.getIpPublic() : audit.getIpPublic());
		audit.setDateRegister(date.currentToDateTime(null));
		audit.setStatu(true);
		AuditEntity auditEntity = auditEntityRepository.save(auditEntityMapper.toEntity(audit));
		if (auditEntity == null)
			throw new CinemaException("No se ha registrado la auditoria.");
		return auditEntityMapper.toDomain(auditEntity);
	}
}
