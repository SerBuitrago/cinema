package com.cinema.application.repository;

import java.util.List;

import com.cinema.dominio.entity.Server;

public interface ServerRepository {

	Server findById(Long id);
	
	Server findByName(String name);
	
	List<Server> findAll();
	
	List<Server> findByStatuAll(boolean statu);
	
	List<Server> findByRangeDateRegisterAll(String start, String end);
	
	Server save(Server server, int type);
	
	boolean delete(Long id);
}
