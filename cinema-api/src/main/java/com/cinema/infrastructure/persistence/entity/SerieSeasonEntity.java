package com.cinema.infrastructure.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "serie_season")
public class SerieSeasonEntity {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false, length = 500)
	private String name;
	
	@Column(name = "idSerie", nullable = false)
	private Long idSerie;
	
	@Column(name = "description", nullable = false, length = 800)
	private String description;

	@Column(name = "statu", nullable = false, columnDefinition = "tinyint(1) default 1")
	private boolean statu;

	@Column(name = "date_register", nullable = false)
	private String dateRegister;

	@Column(name = "date_update", nullable = true)
	private String dateUpdate;
}
