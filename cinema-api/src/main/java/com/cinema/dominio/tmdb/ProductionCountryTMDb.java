package com.cinema.dominio.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

@JsonRootName("production_country")
@Getter
@Setter
public class ProductionCountryTMDb {
	@JsonProperty("iso_3166_1")
    private String isoCode;
    @JsonProperty("name")
    private String name;
}
