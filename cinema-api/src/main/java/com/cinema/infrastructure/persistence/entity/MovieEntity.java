package com.cinema.infrastructure.persistence.entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cinema.dominio.tmdb.MovieTMDb;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class MovieEntity {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false, length = 500)
	private String name;

	@Column(name = "description", nullable = false, length = 800)
	private String description;
	
	@Column(name = "poster", nullable = false, length = 200)
	private String poster;
	
	@Column(name = "backdrop", nullable = false, length = 200)
	private String backdrop;
	
	@Column(name = "average", nullable = false)
	private float average;

	@Column(name = "statu", nullable = false, columnDefinition = "tinyint(1) default 1")
	private boolean statu;

	@Column(name = "date_register", nullable = false)
	private String dateRegister;

	@Column(name = "date_update", nullable = true)
	private String dateUpdate;

	@OneToMany(mappedBy = "idMovie")
	private List<ImageEntity> images;

	@OneToMany(mappedBy = "idMovie")
	private List<GenderMovieEntity> genders;

	@Transient
	private MovieTMDb movieTMDb;
}
