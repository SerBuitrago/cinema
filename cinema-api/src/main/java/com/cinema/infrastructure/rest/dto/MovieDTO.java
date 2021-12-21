package com.cinema.infrastructure.rest.dto;

import java.util.List;

import com.cinema.dominio.GenderMovieSerie;
import com.cinema.dominio.Image;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
	
	private Long id;
	private String name;
	private String description;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
	private List<Image> images;
	private List<GenderMovieSerie> genders;
}
