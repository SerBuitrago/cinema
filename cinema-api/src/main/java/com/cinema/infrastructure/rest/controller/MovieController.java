package com.cinema.infrastructure.rest.controller;

import java.util.List;

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

	@GetMapping(value = { "/{id}", "/find/id/{id}" })
	public ResponseEntity<MovieDTO> findById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(movieMapper.toDto(movieService.findById(id)));
	}

	@GetMapping(value = { "/find/name/{name}" })
	public ResponseEntity<MovieDTO> findByName(@PathVariable("name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(movieMapper.toDto(movieService.findByName(name)));
	}

	@GetMapping(value = { "", "/all" })
	public ResponseEntity<List<MovieDTO>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(movieMapper.toDtoList(movieService.findAll()));
	}

	@GetMapping(value = { "/all/find/statu/{statu}" })
	public ResponseEntity<List<MovieDTO>> findByStatuAll(@PathVariable("statu") boolean statu) {
		return ResponseEntity.status(HttpStatus.OK).body(movieMapper.toDtoList(movieService.findByStatuAll(statu)));
	}

	@GetMapping(value = { "/range/all/find/date/register/{start}/{end}" })
	public ResponseEntity<List<MovieDTO>> findByRangeDateRegisterAll(@PathVariable("start") String start,
			@PathVariable("end") String end) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(movieMapper.toDtoList(movieService.findByRangeDateRegisterAll(start, end)));
	}
}
