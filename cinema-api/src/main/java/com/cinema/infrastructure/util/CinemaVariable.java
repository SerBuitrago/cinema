package com.cinema.infrastructure.util;

public class CinemaVariable {
	public static final String[] CINEMA_ARRAY_DATE = { "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };

	public static final String CINEMA_DATE_ZONA_ID = "America/Bogota";
	public static final String CINEMA_DATE_FORMAT_DATE = "yyyy/MM/dd";
	public static final String CINEMA_DATE_FORMAT_HOUR = "HH:mm:ss";
	public static final String CINEMA_DATE_TIME_FORMAT = CINEMA_DATE_FORMAT_DATE + " " + CINEMA_DATE_FORMAT_HOUR;

	public static final String CINEMA_AUDIT_ACTION_REGISTER = "REGISTRAR";
	public static final String CINEMA_AUDIT_ACTION_UPDATE = "ACTUALIZAR";
	public static final String CINEMA_AUDIT_ACTION_REMOVE_FILTER_ID = "ELIMINAR ID";
	public static final String CINEMA_AUDIT_ACTION_FIND_FILTER_ID = "CONSULTAR ID";
	public static final String CINEMA_AUDIT_ACTION_FIND_FILTER_NAME = "CONSULTAR NOMBRE";
	public static final String CINEMA_AUDIT_ACTION_FIND_ALL = "CONSULTAR TODO";
}
