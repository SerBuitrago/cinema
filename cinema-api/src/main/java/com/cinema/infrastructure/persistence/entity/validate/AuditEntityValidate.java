package com.cinema.infrastructure.persistence.entity.validate;

import com.cinema.dominio.entity.Audit;
import com.cinema.infrastructure.exception.CinemaException;
import com.cinema.infrastructure.util.Cinema;

public class AuditEntityValidate {

	public static void validate(Audit audit) {
		if (audit == null)
			throw new CinemaException("No se ha podido validar la auditoria.");
		if (!Cinema.isString(audit.getDatabase()))
			throw new CinemaException("No se ha recibido la base de datos de la auditoria.");
		if (!Cinema.isString(audit.getTable()))
			throw new CinemaException("No se ha recibido la tabla de la auditoria.");
		if (!Cinema.isString(audit.getAction()))
			throw new CinemaException("No se ha recibido la acción de la auditoria.");
		if (!Cinema.isString(audit.getDescription()))
			throw new CinemaException("No se ha recibido la descripción de la auditoria.");
	}
	
	public static void validateIp(Audit audit) {
		validate(audit);
		if (!Cinema.isString(audit.getIpPublic()))
			throw new CinemaException("No se ha recibido la ip publica de la auditoria.");
		if (!Cinema.isString(audit.getIpLocal()))
			throw new CinemaException("No se ha recibido la ip local de la auditoria.");
	}
}
