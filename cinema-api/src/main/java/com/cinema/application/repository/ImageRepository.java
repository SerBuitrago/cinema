package com.cinema.application.repository;

import com.cinema.dominio.entity.Image;

public interface ImageRepository {

	Image findById(Long id);
}
