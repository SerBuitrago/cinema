package com.cinema.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenderDTO {
	
	private Long id;
	private String name;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
}
