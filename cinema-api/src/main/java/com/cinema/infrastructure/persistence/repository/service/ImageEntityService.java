package com.cinema.infrastructure.persistence.repository.service;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.ImageRepository;
import com.cinema.dominio.entity.Image;
import com.cinema.infrastructure.persistence.mapper.ImageEntityMapper;
import com.cinema.infrastructure.persistence.repository.ImageEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageEntityService implements ImageRepository{
	private final ImageEntityRepository imageRepositoryData;
	private final ImageEntityMapper imageEntityMapper;
	
	@Override
	public Image findById(Long id) {
		return imageEntityMapper.toDomain(imageRepositoryData.findById(id).orElse(null));
	}
}
