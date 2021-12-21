package com.cinema.infrastructure.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class GendersModel {
	
	@JsonProperty("genres")
	List<GenderModel> gendersList;
}
