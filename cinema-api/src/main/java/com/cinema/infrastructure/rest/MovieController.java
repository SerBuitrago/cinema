package com.cinema.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.application.service.MovieService;
import com.cinema.dominio.entity.Movie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {

	private final MovieService movieService;

	@GetMapping(value = { "/{id}", "/find/id/{id}" })
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.findById(id));
	}

	@GetMapping(value = { "/find/name/{name}" })
	public ResponseEntity<?> findByName(@PathVariable("name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.findByName(name));
	}

	@GetMapping(value = { "", "/all" })
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.findAll());
	}

	@GetMapping(value = { "/all/find/statu/{statu}" })
	public ResponseEntity<?> findByStatuAll(@PathVariable("statu") boolean statu) {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.findByStatuAll(statu));
	}

	@GetMapping(value = { "/range/all/find/date/register/{start}/{end}" })
	public ResponseEntity<?> findByRangeDateRegisterAll(@PathVariable("start") String start,
			@PathVariable("end") String end) {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.findByRangeDateRegisterAll(start, end));
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Movie movie) {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.save(movie, 1));
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Movie movie){
		return ResponseEntity.status(HttpStatus.OK).body(movieService.save(movie, 2));
	}
	
	@PutMapping(value = {"/update/statu"})
	public ResponseEntity<?> updateStatu(@RequestBody Movie movie){
		return ResponseEntity.status(HttpStatus.OK).body(movieService.save(movie, 3));
	}
}
