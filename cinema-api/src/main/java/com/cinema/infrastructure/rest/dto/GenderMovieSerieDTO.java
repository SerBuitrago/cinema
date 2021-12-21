package com.cinema.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenderMovieSerieDTO {
	
	private Long id;
	private Long idMovie;
	private Long idSerie;
}
