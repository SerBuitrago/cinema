package com.cinema.application.repository;

import java.util.List;

import com.cinema.dominio.Movie;

public interface MovieRepository {
	
	Movie findById(Long id);
	
	Movie findByName(String name);
	
	List<Movie> findAll();
	
	List<Movie> findByStatuAll(boolean statu);
	
	List<Movie> findByRangeDateRegisterAll(String start, String end);
}
