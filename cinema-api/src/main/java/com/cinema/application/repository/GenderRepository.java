package com.cinema.application.repository;

import java.util.List;

import com.cinema.dominio.entity.Gender;

public interface GenderRepository {

	Gender findById(Long id);
	
	Gender findByName(String name);
	
	List<Gender> findAll();
	
	List<Gender> findByStatuAll(boolean statu);
	
	List<Gender> findByRangeDateRegisterAll(String start, String end);
	
	Gender save(Gender gender);
}
