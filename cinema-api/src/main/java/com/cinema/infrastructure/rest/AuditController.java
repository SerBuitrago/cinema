package com.cinema.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.application.service.AuditService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/audit")
public class AuditController {
	
	private final AuditService auditService;
	
	@GetMapping(value = { "/{id}", "/find/id/{id}" })
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(auditService.findById(id));
	}
	
	@GetMapping(value = { "", "/all" })
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(auditService.findAll());
	}

	@GetMapping(value = { "/all/find/statu/{statu}" })
	public ResponseEntity<?> findByStatuAll(@PathVariable("statu") boolean statu) {
		return ResponseEntity.status(HttpStatus.OK).body(auditService.findByStatuAll(statu));
	}

	@GetMapping(value = { "/range/all/find/date/register/{start}/{end}" })
	public ResponseEntity<?> findByRangeDateRegisterAll(@PathVariable("start") String start,
			@PathVariable("end") String end) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(auditService.findByRangeDateRegisterAll(start, end));
	}
}
