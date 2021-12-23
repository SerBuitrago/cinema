package com.cinema.dominio.entity;

import lombok.Data;

@Data
public class ServerMovie {
	
	private Long id;
	private Long idServer;
	private Long idMovie;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
}
