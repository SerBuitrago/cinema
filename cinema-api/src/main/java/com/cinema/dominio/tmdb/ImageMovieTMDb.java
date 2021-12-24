package com.cinema.dominio.tmdb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageMovieTMDb {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("backdrops")
	private List<ImageTMDb> backdrops;
	
	@JsonProperty("posters")
	private List<ImageTMDb> posters;
	
	@JsonProperty("logos")
	private List<ImageTMDb> logos;
}
