package com.cinema.dominio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenderMovie {
	
	private Long id;
	private Long idMovie;
	private Long idGender;
	private boolean statu;
	private String dateRegister;
	
	public GenderMovie(Long idMovie, Long idGender) {
		this.idMovie = idMovie;
		this.idGender = idGender;
	}
}
