package com.cinema.dominio.tmdb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class GendersTMDb {
	
	@JsonProperty("genres")
	List<GenderTMDb> gendersList;
}
