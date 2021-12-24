package com.cinema.dominio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gender {
	
	private Long id;
	private String name;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
	
	public Gender(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
