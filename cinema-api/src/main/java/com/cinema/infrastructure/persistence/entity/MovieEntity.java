package com.cinema.infrastructure.persistence.entity;

import javax.persistence.Id;
import javax.persistence.Table;
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
	private Long id;

	private String name;
}
