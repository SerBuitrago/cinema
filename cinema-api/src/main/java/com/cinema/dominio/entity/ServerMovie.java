package com.cinema.dominio.entity;

import lombok.Data;

@Data
public class ServerMovie {
	
	private Long id;
	private Server server;
	private Long idMovie;
	private String path;
	private String time;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
}
