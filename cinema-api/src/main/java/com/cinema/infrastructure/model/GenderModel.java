package com.cinema.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenderModel {
	
	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;
}
