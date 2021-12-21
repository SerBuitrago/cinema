package com.cinema.infrastructure.persistence.repository.service;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.ImageRepository;
import com.cinema.dominio.Image;
import com.cinema.infrastructure.persistence.mapper.ImageEntityMapper;
import com.cinema.infrastructure.persistence.repository.ImageRepositoryData;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageEntityRepository implements ImageRepository{
	private final ImageRepositoryData imageRepositoryData;
	private final ImageEntityMapper imageEntityMapper;
	
	@Override
	public Image findById(Long id) {
		return imageEntityMapper.toDomain(imageRepositoryData.findById(id).orElse(null));
	}
}