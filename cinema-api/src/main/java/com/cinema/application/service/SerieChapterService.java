package com.cinema.application.service;

import com.cinema.application.repository.SerieChapterRepository;
import com.cinema.dominio.entity.SerieChapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SerieChapterService implements SerieChapterRepository{
	
	private final SerieChapterRepository serieChapterRepository;
	
	@Override
	public SerieChapter findById(Long id) {
		return serieChapterRepository.findById(id);
	}
}
