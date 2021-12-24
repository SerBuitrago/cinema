package com.cinema.dominio.entity;

import java.util.List;

import com.cinema.dominio.tmdb.MovieTMDb;

import lombok.Data;

@Data
public class Movie {
	
	private Long id;
	private String name;
	private String description;
	private boolean statu;
	private String poster;
	private String backdrop;
	private float average;
	private String dateRegister;
	private String dateUpdate;
	
	private List<Image> images;
	
	private MovieTMDb movieTMDb;
}
