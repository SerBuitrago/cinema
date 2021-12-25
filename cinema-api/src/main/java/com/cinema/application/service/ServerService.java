package com.cinema.application.service;

import java.util.List;

import com.cinema.application.repository.ServerRepository;
import com.cinema.dominio.entity.Server;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerService implements ServerRepository{
	
	private final ServerRepository serverRepository;

	@Override
	public Server findById(Long id) {
		return serverRepository.findById(id);
	}
	
	@Override
	public Server findByName(String name) {
		return serverRepository.findByName(name);
	}

	@Override
	public List<Server> findAll() {
		return serverRepository.findAll();
	}

	@Override
	public List<Server> findByStatuAll(boolean statu) {
		return serverRepository.findByStatuAll(statu);
	}

	@Override
	public List<Server> findByRangeDateRegisterAll(String start, String end) {
		return serverRepository.findByRangeDateRegisterAll(start, end);
	}

	@Override
	public Server save(Server server, int type) {
		return serverRepository.save(server, type);
	}

	@Override
	public boolean delete(Long id) {
		return serverRepository.delete(id);
	}
}
