package com.cinema.infrastructure.tmdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenderTMDb {
	
	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;
}
