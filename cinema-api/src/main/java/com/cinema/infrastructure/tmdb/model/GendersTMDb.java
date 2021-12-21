package com.cinema.infrastructure.tmdb.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class GendersTMDb {
	
	@JsonProperty("genres")
	List<GenderTMDb> gendersList;
}
