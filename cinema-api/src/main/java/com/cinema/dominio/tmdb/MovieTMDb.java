package com.cinema.dominio.tmdb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MovieTMDb {
	
    @JsonProperty("adult")
    private boolean adult;
    
    @JsonProperty("backdrop_path")
    private String backdropPath;
    
    @JsonProperty("budget")
    private long budget;
    
    @JsonProperty("genres")
    private List<GenderTMDb> genres;
    
    @JsonProperty("homepage")
    private String homepage;
    
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("imdb_id")
    private String imdbID;
    
    @JsonProperty("original_language")
    private String originalLanguage;
    
    @JsonProperty("original_title")
    private String originalTitle;
    
    @JsonProperty("overview")
    private String overview;
    
    @JsonProperty("popularity")
    private float popularity;
    
    @JsonProperty("poster_path")
    private String posterPath;
    
    @JsonProperty("production_companies")
    private List<ProductionCompanyTMDb> productionCompanies;
    
    @JsonProperty("production_countries")
    private List<ProductionCountryTMDb> productionCountries;
    
    @JsonProperty("release_date")
    private String releaseDate;
    
    @JsonProperty("revenue")
    private long revenue;
    
    @JsonProperty("runtime")
    private int runtime;
    
    @JsonProperty("spoken_languages")
    private List<LanguageTMDb> spokenLanguages;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("tagline")
    private String tagline;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("video")
    private boolean video;
    
    @JsonProperty("vote_average")
    private float voteAverage;
    
    @JsonProperty("vote_count")
    private int voteCount;
    
    @JsonProperty("rating")
    private float userRating;
}
