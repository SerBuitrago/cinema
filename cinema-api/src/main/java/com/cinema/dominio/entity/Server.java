package com.cinema.dominio.entity;

import lombok.Data;

@Data
public class Server {
	
	private Long id;
	private String name;
	private String image;
	private String description;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
}
