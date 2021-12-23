package com.cinema.dominio.entity;

import lombok.Data;

@Data
public class SerieSeason {
	
	private Long id;
	private String name;
	private Long idSerie;
	private String description;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
}
