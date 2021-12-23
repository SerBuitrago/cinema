package com.cinema.dominio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audit {

	private Long id;
	private String database;
	private String table;
	private String action;
	private Long idUser;
	private String ipPublic;
	private String ipLocal;
	private String description;
	private boolean statu;
	private String dateRegister;

	public Audit(String database, String table, String action, String description) {
		this(database, table, null, action, description);
	}

	public Audit(String database, String table, Long idUser, String action, String description) {
		this.database = database;
		this.table = table;
		this.idUser = idUser;
		this.action = action;
		this.description = description;
	}
}
