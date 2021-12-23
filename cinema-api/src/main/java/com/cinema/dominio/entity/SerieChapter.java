package com.cinema.dominio.entity;

import lombok.Data;

@Data
public class SerieChapter {
	private Long id;
	private Long idSeason;
	private String description;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
}
