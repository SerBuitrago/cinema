package com.cinema.application.service;

import java.util.List;

import com.cinema.application.repository.ServerMovieRepository;
import com.cinema.dominio.entity.ServerMovie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerMovieService implements ServerMovieRepository{

	private final ServerMovieRepository serverMovieRepository;

	@Override
	public ServerMovie findById(Long id) {
		return serverMovieRepository.findById(id);
	}

	@Override
	public ServerMovie findByMovieAndServer(Long idServer, Long idMovie) {
		return serverMovieRepository.findByMovieAndServer(idServer, idMovie);
	}

	@Override
	public List<ServerMovie> findAll() {
		return serverMovieRepository.findAll();
	}

	@Override
	public List<ServerMovie> findByMovieAll(Long idMovie) {
		return serverMovieRepository.findByMovieAll(idMovie);
	}

	@Override
	public List<ServerMovie> findByServerAll(Long idServer) {
		return serverMovieRepository.findByServerAll(idServer);
	}

	@Override
	public List<ServerMovie> findByStatuAll(boolean statu) {
		return serverMovieRepository.findByStatuAll(statu);
	}

	@Override
	public List<ServerMovie> findByRangeDateRegisterAll(String start, String end) {
		return serverMovieRepository.findByRangeDateRegisterAll(start, end);
	}

	@Override
	public ServerMovie save(ServerMovie serverMovie, int type) {
		return serverMovieRepository.save(serverMovie, type);
	}

	@Override
	public boolean delete(Long id) {
		return serverMovieRepository.delete(id);
	}
}
