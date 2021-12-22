package com.cinema.dominio.entity;

import lombok.Data;

@Data
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
}
