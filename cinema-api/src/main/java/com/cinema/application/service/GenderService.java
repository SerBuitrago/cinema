package com.cinema.application.service;

import java.util.List;

import com.cinema.application.repository.GenderRepository;
import com.cinema.dominio.entity.Gender;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenderService implements GenderRepository{
	
	private final GenderRepository genderRepository;
	
	public Gender findById(Long id) {
		return genderRepository.findById(id);
	}

	@Override
	public Gender findByName(String name) {
		return genderRepository.findByName(name);
	}

	@Override
	public List<Gender> findAll() {
		return genderRepository.findAll();
	}

	@Override
	public List<Gender> findByStatuAll(boolean statu) {
		return genderRepository.findByStatuAll(statu);
	}

	@Override
	public List<Gender> findByRangeDateRegisterAll(String start, String end) {
		return genderRepository.findByRangeDateRegisterAll(start, end);
	}

	@Override
	public Gender save(Gender gender) {
		return genderRepository.save(gender);
	}
}
