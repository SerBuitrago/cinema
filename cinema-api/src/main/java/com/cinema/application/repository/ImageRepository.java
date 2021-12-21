package com.cinema.application.repository;

import com.cinema.dominio.Image;

public interface ImageRepository {

	Image findById(Long id);
}
