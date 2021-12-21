package com.cinema.application.service;

import com.cinema.application.repository.GenderRepository;
import com.cinema.dominio.Gender;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenderService {
	
	private final GenderRepository genderRepository;
	
	public Gender findById(Long id) {
		return genderRepository.findById(id);
	}
}
