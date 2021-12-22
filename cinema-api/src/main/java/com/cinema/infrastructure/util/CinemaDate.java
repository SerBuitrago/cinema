package com.cinema.infrastructure.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import lombok.Data;

@Data
public class CinemaDate implements Serializable {

	private static final long serialVersionUID = 1L;

	private String date;

	private LocalDate localDate;
	private LocalTime localTime;
	private LocalDateTime localDateTime;

	private ZoneId zone;
	private DateTimeFormatter format;

	public CinemaDate() {
		initZoneId(null);
		initFormat(null);
	}

	/**
	 * Method that initializes the zone.
	 * 
	 * @param zone - Represents the time zone.
	 */
	public void initZoneId(String zone) {
		this.zone = ZoneId.of((Cinema.isString(zone)) ? zone : CinemaVariable.CINEMA_DATE_ZONA_ID);
	}

	/**
	 * Method that allows you to format the dates.
	 * 
	 * @param format - Represents the format to use.
	 */
	public void initFormat(String format) {
		this.format = DateTimeFormatter
				.ofPattern((Cinema.isString(format)) ? format : CinemaVariable.CINEMA_DATE_TIME_FORMAT);
	}

	/**
	 * Method that allows knowing the current month.
	 * 
	 * @return the current month.
	 */
	public int currentYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	/**
	 * Method that allows to know the current year.
	 * 
	 * @return the current year.
	 */
	public int currentMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH);
	}

	/**
	 * Method that allows knowing the name of the current month.
	 * 
	 * @return the current month name.
	 */
	public String currentMonthName() {
		try {
			return CinemaVariable.CINEMA_ARRAY_DATE[currentMonth()];
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Method that allows obtaining the current date.
	 * 
	 * @param format, Represents the format to use.
	 * @return The string obtained.
	 */
	public String currentToDate(String format) {
		initFormat((Cinema.isString(format)) ? format : CinemaVariable.CINEMA_DATE_FORMAT_DATE);
		localDate = LocalDate.now();
		this.date = localDate.format(this.format);
		return date;
	}

	/**
	 * Method that allows obtaining the current time.
	 * 
	 * @param format, Represents the format to use.
	 * @return The string obtained.
	 */
	public String currentTime(String format) {
		initFormat((Cinema.isString(format)) ? format : CinemaVariable.CINEMA_DATE_FORMAT_HOUR);
		localTime = LocalTime.now();
		this.date = localTime.format(this.format);
		return date;
	}

	/**
	 * Method that allows obtaining the current date and time.
	 * 
	 * @param format, Represents the format to use.
	 * @return The string obtained.
	 */
	public String currentToDateTime(String format) {
		initFormat((Cinema.isString((format)) ? format : CinemaVariable.CINEMA_DATE_TIME_FORMAT));
		this.localDateTime = LocalDateTime.now();
		this.date = localDateTime.format(this.format);
		return date;
	}

	/**
	 * Method that converts a date.
	 * 
	 * @param date, Represents the convert date.
	 * @return the converted date.
	 * @throws ParseException The error presented.
	 */
	public Date convertToDate(String date) throws ParseException {
		SimpleDateFormat dt = new SimpleDateFormat(CinemaVariable.CINEMA_DATE_FORMAT_DATE);
		return dt.parse(date);
	}

	/**
	 * Method that converts a date time.
	 * 
	 * @param date, Represents the convert date.
	 * @return the converted date.
	 * @throws ParseException The error presented.
	 */
	public Date convertToDateTime(String date) throws ParseException {
		SimpleDateFormat dt = new SimpleDateFormat(CinemaVariable.CINEMA_DATE_TIME_FORMAT);
		return dt.parse(date);
	}

	public String formatToDateTime(Date date, String format) {
		if (date != null) {
			if (!Cinema.isString(format))
				format = CinemaVariable.CINEMA_DATE_TIME_FORMAT;
			DateFormat f = new SimpleDateFormat(format);
			return f.format(date);
		}
		return null;
	}

	public Date combineFormatToDateTime(Date date, String format) {
		try {
			return convertToDateTime(formatToDateTime(date, format));
		} catch (ParseException e) {
			return null;
		}
	}
}
