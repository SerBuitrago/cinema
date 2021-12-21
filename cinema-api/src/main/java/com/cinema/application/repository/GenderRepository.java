package com.cinema.application.repository;

import com.cinema.dominio.Gender;

public interface GenderRepository {

	Gender findById(Long id);
}
