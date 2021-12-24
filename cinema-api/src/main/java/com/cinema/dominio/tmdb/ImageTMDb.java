package com.cinema.dominio.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageTMDb {
	
	@JsonProperty("aspect_ratio")
	private float idaspectRatio;
	
	@JsonProperty("height")
	private int height;
	
	@JsonProperty("width")
	private int width;
	
	@JsonProperty("file_path")
	private String path;
	
	@JsonProperty("vote_average")
	private int voteAverage;
	
	@JsonProperty("vote_count")
	private int voteCount;
}
