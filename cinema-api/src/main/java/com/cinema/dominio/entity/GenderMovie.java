package com.cinema.dominio.entity;

import lombok.Data;

@Data
public class GenderMovie {
	
	private Long id;
	private Long idMovie;
	private boolean statu;
	private String dateRegister;
}
