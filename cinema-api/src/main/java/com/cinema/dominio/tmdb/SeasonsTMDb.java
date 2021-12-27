package com.cinema.dominio.tmdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SeasonsTMDb {
	
	@JsonProperty("air_date")
    private String airDate;
	
	@JsonProperty("episode_count")
    private int episodeCount;
	
	@JsonProperty("id")
    private Long id;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("overview")
    private String overview;
	
    @JsonProperty("poster_path")
    private String posterPath;
    
    @JsonProperty("season_number")
    private int seasonNumber;
}
