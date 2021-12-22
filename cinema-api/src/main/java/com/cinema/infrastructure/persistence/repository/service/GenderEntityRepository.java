package com.cinema.infrastructure.persistence.repository.service;

import org.springframework.stereotype.Service;

import com.cinema.application.repository.GenderRepository;
import com.cinema.dominio.entity.Gender;
import com.cinema.infrastructure.persistence.mapper.GenderEntityMapper;
import com.cinema.infrastructure.persistence.repository.GenderRepositoryData;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GenderEntityRepository implements GenderRepository{
	
	private final GenderRepositoryData genderRepositoryData;
	private final GenderEntityMapper genderEntityMapper;
	
	@Override
	public Gender findById(Long id) {
		return genderEntityMapper.toDomain(genderRepositoryData.findById(id).orElse(null));
	}
}
