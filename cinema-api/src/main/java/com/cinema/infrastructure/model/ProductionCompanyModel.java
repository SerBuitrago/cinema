package com.cinema.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

@JsonRootName("production_company")
@Getter
@Setter
public class ProductionCompanyModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("logo_path")
    private String logoPath;

    @JsonProperty("origin_country")
    private String originCountry;
}