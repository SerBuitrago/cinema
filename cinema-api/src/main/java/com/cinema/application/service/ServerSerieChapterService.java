package com.cinema.application.service;

import com.cinema.application.repository.ServerSerieChapterRepository;
import com.cinema.dominio.entity.ServerSerieChapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerSerieChapterService implements ServerSerieChapterRepository{
	
	private final ServerSerieChapterRepository serieChapterRepository;
	
	@Override
	public ServerSerieChapter findById(Long id) {
		return serieChapterRepository.findById(id);
	}

}
