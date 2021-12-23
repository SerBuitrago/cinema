package com.cinema.application.service;

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

}
