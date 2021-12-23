package com.cinema.infrastructure.util;

import com.cinema.dominio.entity.Audit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaAudit {

	private String database;
	private String table;
	private Long idUser;
	private String name;

	private Audit audit;

	public CinemaAudit(String database, String table, Long idUser, String name) {
		this.database = database;
		this.table = table;
		this.idUser = idUser;
		this.name = name;
	}

	public Audit findById(Long id) {
		String description = "Se ha recibido el valor "+id+" consultado "+name+" por su id.";
		init(CinemaVariable.CINEMA_AUDIT_ACTION_FIND_FILTER_ID, description);
		return this.audit;
	}
	
	public Audit findByName(String name) {
		String description = "Se ha recibido el valor "+name+" consultado "+this.name+" por su nombre.";
		init(CinemaVariable.CINEMA_AUDIT_ACTION_FIND_FILTER_NAME, description);
		return this.audit;
	}

	public void init(String action, String description) {
		audit = new Audit(database, table, idUser, action, description);
	}
}
