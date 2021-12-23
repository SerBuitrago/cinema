package com.cinema.application.repository;

import com.cinema.dominio.entity.Server;

public interface ServerRepository {

	Server findById(Long id);
}
