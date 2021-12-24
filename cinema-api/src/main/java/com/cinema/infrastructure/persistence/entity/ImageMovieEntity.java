package com.cinema.infrastructure.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "image_movie")
public class ImageMovieEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_movie", nullable = true)
	private Long idMovie;
	
	@Column(name = "path", nullable = false, length = 500)
	private String path;
	
	@Column(name = "statu", nullable = false, columnDefinition = "tinyint(1) default 1")
	private boolean statu;
	
	@Column(name = "backdrops", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean backdrops;
	
	@Column(name = "posters", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean posters;
	
	@Column(name = "logos", nullable = false, columnDefinition = "tinyint(1) default 0")
	private boolean logos;
	
	@Column(name="date_register", nullable = false)
	private String dateRegister;
	
	@Column(name="date_update", nullable = true)
	private String dateUpdate;
}
