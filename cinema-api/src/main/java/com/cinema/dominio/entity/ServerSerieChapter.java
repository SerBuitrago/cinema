package com.cinema.dominio.entity;

import lombok.Data;

@Data
public class ServerSerieChapter {
	
	private Long id;
	private Long idServer;
	private Long idSerieChapter;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
}
