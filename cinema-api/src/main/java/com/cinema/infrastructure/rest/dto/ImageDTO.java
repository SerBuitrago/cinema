package com.cinema.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
	
	private Long id;
	private Long idMovie;
	private Long idSerie;
	private String path;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
}
