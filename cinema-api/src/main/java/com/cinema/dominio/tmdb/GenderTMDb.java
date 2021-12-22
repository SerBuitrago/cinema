package com.cinema.dominio.tmdb;

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
