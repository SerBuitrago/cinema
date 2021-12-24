package com.cinema.application.repository;

import java.util.List;

import com.cinema.dominio.entity.ImageMovie;

public interface ImageMovieRepository {

	ImageMovie findById(Long id);
	
	List<ImageMovie> findByStatuAll(boolean statu);
	
	List<ImageMovie> findByRangeDateRegisterAll(String start, String end);
	
	ImageMovie save(ImageMovie imageMovie);
}
