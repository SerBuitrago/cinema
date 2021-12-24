package com.cinema.application.repository;

import java.util.List;

import com.cinema.dominio.entity.GenderMovie;

public interface GenderMovieRepository {
	
	GenderMovie findById(Long id);
	
	GenderMovie findByMovieAndGender(Long idMovie, Long idGender);
	
	List<GenderMovie> findByStatuAll(boolean statu);
	
	GenderMovie save(GenderMovie genderMovie);
	
	boolean delete(Long id);
}
