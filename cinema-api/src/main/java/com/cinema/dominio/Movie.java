package com.cinema.dominio;

import java.util.List;

import lombok.Data;

@Data
public class Movie {
	
	private Long id;
	private String name;
	private String description;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
	private List<Image> images;
	private List<GenderMovieSerie> genders;
}
