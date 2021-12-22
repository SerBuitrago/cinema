package com.cinema.infrastructure.util;

import java.text.ParseException;
import java.util.List;

import com.cinema.infrastructure.exception.CinemaException;

public class Cinema {
	
	public static boolean isString(String string) {
		return string != null && string.trim().length() > 0;
	}
	
	public static boolean isLong(Long value) {
		return value != null && value > 0;
	}
	
	public static <T> boolean isList(List<T> list) {
		return list != null && !list.isEmpty();
	}
	
	public static String [] isRangeDateRegister(String start, String end) {
		if (isString(start) && isString(end)) {
			CinemaDate date = new CinemaDate();
			try {
				String array_date[] = { date.formatToDateTime(date.convertToDate(start.replaceAll("-", "/")), null),
						date.formatToDateTime(date.convertToDate(end.replaceAll("-", "/")), null) };
				return array_date;
			} catch (ParseException e) {
				throw new CinemaException("El formato permitido para las fechas es: 'Año-Mes-Dia'.");
			}
		} else {
			throw new CinemaException("No se ha recibido la fecha inicio o la fecha fin.");
		}
	}
}
