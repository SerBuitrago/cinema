package com.cinema.application.service;

import java.util.List;

import com.cinema.application.repository.ImageMovieRepository;
import com.cinema.dominio.entity.ImageMovie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImageMovieService implements ImageMovieRepository{
	
	private final ImageMovieRepository imageRepository;
	
	public ImageMovie findById(Long id) {
		return imageRepository.findById(id);
	}

	@Override
	public List<ImageMovie> findByStatuAll(boolean statu) {
		return imageRepository.findByStatuAll(statu);
	}

	@Override
	public List<ImageMovie> findByRangeDateRegisterAll(String start, String end) {
		return imageRepository.findByRangeDateRegisterAll(start, end);
	}

	@Override
	public ImageMovie save(ImageMovie imageMovie) {
		return imageRepository.save(imageMovie);
	}
}
