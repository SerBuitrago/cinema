package com.cinema.dominio;

import lombok.Data;

@Data
public class Image {
	
	private Long id;
	private Long idMovie;
	private Long idSerie;
	private String path;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
}
