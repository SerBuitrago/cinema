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

import com.cinema.application.service.ServerMovieService;
import com.cinema.dominio.entity.ServerMovie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/server-movie")
public class ServerMovieController {
	
	private final ServerMovieService serverMovieService;
	
	@GetMapping(value = { "/{id}", "/find/id/{id}" })
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(serverMovieService.findById(id));
	}

	@GetMapping(value = { "/find/movie/{idMovie}/server/{idServer}" })
	public ResponseEntity<?> findByMovieAndServer(@PathVariable("idMovie") Long idMovie, @PathVariable("idServer") Long idServer) {
		return ResponseEntity.status(HttpStatus.OK).body(serverMovieService.findByMovieAndServer(idServer, idMovie));
	}

	@GetMapping(value = { "", "/all" })
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(serverMovieService.findAll());
	}
	
	@GetMapping(value = { "/all/find/movie/{idMovie}" })
	public ResponseEntity<?> findByMovieAll(@PathVariable("idMovie") Long idMovie) {
		return ResponseEntity.status(HttpStatus.OK).body(serverMovieService.findByMovieAll(idMovie));
	}
	
	@GetMapping(value = { "/all/find/server/{idServer}" })
	public ResponseEntity<?> findByServerAll(@PathVariable("idServer") Long idServer) {
		return ResponseEntity.status(HttpStatus.OK).body(serverMovieService.findByServerAll(idServer));
	}

	@GetMapping(value = { "/all/find/statu/{statu}" })
	public ResponseEntity<?> findByStatuAll(@PathVariable("statu") boolean statu) {
		return ResponseEntity.status(HttpStatus.OK).body(serverMovieService.findByStatuAll(statu));
	}

	@GetMapping(value = { "/range/all/find/date/register/{start}/{end}" })
	public ResponseEntity<?> findByRangeDateRegisterAll(@PathVariable("start") String start,
			@PathVariable("end") String end) {
		return ResponseEntity.status(HttpStatus.OK).body(serverMovieService.findByRangeDateRegisterAll(start, end));
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody ServerMovie serverMovie) {
		return ResponseEntity.status(HttpStatus.OK).body(serverMovieService.save(serverMovie, 1));
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ServerMovie serverMovie){
		return ResponseEntity.status(HttpStatus.OK).body(serverMovieService.save(serverMovie, 2));
	}
	
	@PutMapping(value = {"/update/statu"})
	public ResponseEntity<?> updateStatu(@RequestBody ServerMovie serverMovie){
		return ResponseEntity.status(HttpStatus.OK).body(serverMovieService.save(serverMovie, 3));
	}
}
