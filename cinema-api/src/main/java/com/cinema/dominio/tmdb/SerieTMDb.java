package com.cinema.dominio.tmdb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SerieTMDb {

    @JsonProperty("backdrop_path")
    private String backdropPath;
    
    @JsonProperty("first_air_date")
    private String firstAirDate;
    
    @JsonProperty("genres")
    private List<GenderTMDb> genres;
    
    @JsonProperty("homepage")
    private String homepage;
    
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("in_production")
    private boolean inProduction;
    
    @JsonProperty("last_air_date")
    private String lastAirDate;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("number_of_episodes")
    private int numberOfEpisodes;
    
    @JsonProperty("number_of_seasons")
    private int numberOfSeasons;
    
    @JsonProperty("original_language")
    private String originalLanguage;
    
    @JsonProperty("original_name")
    private String originalName;
    
    @JsonProperty("overview")
    private String overview;
    
    @JsonProperty("popularity")
    private float popularity;
    
    @JsonProperty("poster_path")
    private String poster_path;
    
    @JsonProperty("production_companies")
    private List<ProductionCompanyTMDb> productionCompanies;
    
    @JsonProperty("production_countries")
    private List<ProductionCountryTMDb> productionCountries;
    
    @JsonProperty("seasons")
    private List<SeasonsTMDb> seasons;
    
    @JsonProperty("spoken_languages")
    private List<LanguageTMDb> spokenLanguages;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("tagline")
    private String tagline;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("vote_average")
    private float voteAverage;
    
    @JsonProperty("vote_count")
    private int voteCount;    
}
