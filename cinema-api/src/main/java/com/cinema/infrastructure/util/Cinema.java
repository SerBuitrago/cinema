package com.cinema.infrastructure.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cinema.infrastructure.exception.CinemaException;

public class Cinema {

	private static final Logger LOGGER = LoggerFactory.getLogger(Cinema.class);

	public static boolean isString(String string) {
		return string != null && string.trim().length() > 0;
	}

	public static boolean isLong(Long value) {
		return value != null && value > 0;
	}

	public static <T> boolean isList(List<T> list) {
		return list != null && !list.isEmpty();
	}

	public static String[] isRangeDateRegister(String start, String end) {
		if (isString(start) && isString(end)) {
			CinemaDate date = new CinemaDate();
			try {
				String array_date[] = { date.formatToDateTime(date.convertToDate(start.replaceAll("-", "/")), null),
						date.formatToDateTime(date.convertToDate(end.replaceAll("-", "/")), null) };
				return array_date;
			} catch (ParseException e) {
				LOGGER.error("isRangeDateRegister(String start, String end)", e);
				throw new CinemaException("El formato permitido para las fechas es: 'Año-Mes-Dia'.");
			}
		} else {
			throw new CinemaException("No se ha recibido la fecha inicio o la fecha fin.");
		}
	}

	public static String getIpLocal() {
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
			return address.getHostAddress();
		} catch (UnknownHostException e) {
			LOGGER.error("getIpLocal()", e);
			return null;
		}
	}

	@SuppressWarnings("resource")
	public static String getIpPublic() {
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress("google.com", 80));
			return socket.getLocalAddress().getHostAddress();
		} catch (IOException e) {
			LOGGER.error("getIpPublic()", e);
			return null;
		}
	}

	public static String message(int type, boolean plural) {
		String message = null;
		switch (type) {
		case 1:
			message = "registrado";
			break;
		case 2:
			message = "actualizado";
			break;
		case 3:
			message = "actualizado el estado";
			break;
		case 4:
			message = "actualizando cantidad";
			break;
		default:
			message = "n/a";
			break;
		}
		return message;
	}
}
