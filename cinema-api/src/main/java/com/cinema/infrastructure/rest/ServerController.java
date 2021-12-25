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

import com.cinema.application.service.ServerService;
import com.cinema.dominio.entity.Server;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/server")
public class ServerController {
	
	private final ServerService serverService;
	
	@GetMapping(value = { "/{id}", "/find/id/{id}" })
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(serverService.findById(id));
	}

	@GetMapping(value = { "/find/name/{name}" })
	public ResponseEntity<?> findByName(@PathVariable("name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(serverService.findByName(name));
	}

	@GetMapping(value = { "", "/all" })
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(serverService.findAll());
	}

	@GetMapping(value = { "/all/find/statu/{statu}" })
	public ResponseEntity<?> findByStatuAll(@PathVariable("statu") boolean statu) {
		return ResponseEntity.status(HttpStatus.OK).body(serverService.findByStatuAll(statu));
	}

	@GetMapping(value = { "/range/all/find/date/register/{start}/{end}" })
	public ResponseEntity<?> findByRangeDateRegisterAll(@PathVariable("start") String start,
			@PathVariable("end") String end) {
		return ResponseEntity.status(HttpStatus.OK).body(serverService.findByRangeDateRegisterAll(start, end));
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Server server) {
		return ResponseEntity.status(HttpStatus.OK).body(serverService.save(server, 1));
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Server server){
		return ResponseEntity.status(HttpStatus.OK).body(serverService.save(server, 2));
	}
	
	@PutMapping(value = {"/update/statu"})
	public ResponseEntity<?> updateStatu(@RequestBody Server server){
		return ResponseEntity.status(HttpStatus.OK).body(serverService.save(server, 3));
	}
}
