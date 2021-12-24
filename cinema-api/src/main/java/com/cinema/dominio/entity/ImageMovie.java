package com.cinema.dominio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageMovie {
	
	private Long id;
	private Long idMovie;
	private String path;
	private boolean statu;
	private boolean backdrops;
	private boolean posters;
	private boolean logos;
	private String dateRegister;
	private String dateUpdate;
	
	public ImageMovie(Long idMovie, boolean backdrops, boolean posters, boolean logos) {
		this.idMovie = idMovie;
		this.backdrops = backdrops;
		this.posters = posters;
		this.logos = logos;
	}	
}
