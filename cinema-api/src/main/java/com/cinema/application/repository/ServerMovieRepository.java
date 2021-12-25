package com.cinema.application.repository;

import java.util.List;

import com.cinema.dominio.entity.ServerMovie;

public interface ServerMovieRepository {

	ServerMovie findById(Long id);
	
	ServerMovie findByMovieAndServer(Long idServer, Long idMovie);
	
	List<ServerMovie> findAll();
	
	List<ServerMovie> findByMovieAll(Long idMovie);
	
	List<ServerMovie> findByServerAll(Long idServer);
	
	List<ServerMovie> findByStatuAll(boolean statu);
	
	List<ServerMovie> findByRangeDateRegisterAll(String start, String end);
	
	ServerMovie save(ServerMovie serverMovie, int type);
	
	boolean delete(Long id);
}
