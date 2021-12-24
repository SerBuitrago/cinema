package com.cinema.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.application.service.GenderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/gender")
public class GenderController {
	
	private final GenderService GenderService;

	@GetMapping(value = { "/{id}", "/find/id/{id}" })
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(GenderService.findById(id));
	}

	@GetMapping(value = { "/find/name/{name}" })
	public ResponseEntity<?> findByName(@PathVariable("name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body(GenderService.findByName(name));
	}

	@GetMapping(value = { "", "/all" })
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(GenderService.findAll());
	}

	@GetMapping(value = { "/all/find/statu/{statu}" })
	public ResponseEntity<?> findByStatuAll(@PathVariable("statu") boolean statu) {
		return ResponseEntity.status(HttpStatus.OK).body(GenderService.findByStatuAll(statu));
	}

	@GetMapping(value = { "/range/all/find/date/register/{start}/{end}" })
	public ResponseEntity<?> findByRangeDateRegisterAll(@PathVariable("start") String start,
			@PathVariable("end") String end) {
		return ResponseEntity.status(HttpStatus.OK).body(GenderService.findByRangeDateRegisterAll(start, end));
	}
}
