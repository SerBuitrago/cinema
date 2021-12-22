package com.cinema.application.repository;

import com.cinema.dominio.entity.Gender;

public interface GenderRepository {

	Gender findById(Long id);
}
