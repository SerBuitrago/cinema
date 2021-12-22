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
@Table(name = "audit")
public class AuditEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name_database", nullable = false, length = 500)
	private String database;
	
	@Column(name = "name_table", nullable = false, length = 500)
	private String table;
	
	@Column(name = "action", nullable = false, length = 500)
	private String action;
	
	@Column(name = "idUser", nullable = true)
	private Long idUser;
	
	@Column(name = "ipPublic", nullable = false, length = 20)
	private String ipPublic;
	
	@Column(name = "ipLocal", nullable = false, length = 20)
	private String ipLocal;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "statu", nullable = false, columnDefinition = "tinyint(1) default 1")
	private boolean statu;
	
	@Column(name="date_register", nullable = false)
	private String dateRegister;
}
