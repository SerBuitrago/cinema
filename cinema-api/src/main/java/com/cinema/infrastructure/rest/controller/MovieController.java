package com.cinema.infrastructure.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.application.service.MovieService;
import com.cinema.infrastructure.rest.dto.MovieDTO;
import com.cinema.infrastructure.rest.mapper.MovieMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {

	private final MovieService movieService;
	private final MovieMapper movieMapper;

	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		return new ResponseEntity<>(movieMapper.toDto(movieService.findById(id)), HttpStatus.OK);
	}
}
