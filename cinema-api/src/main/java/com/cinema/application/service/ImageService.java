package com.cinema.application.service;

import com.cinema.application.repository.ImageRepository;
import com.cinema.dominio.entity.Image;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	public Image findById(Long id) {
		return imageRepository.findById(id);
	}
}
