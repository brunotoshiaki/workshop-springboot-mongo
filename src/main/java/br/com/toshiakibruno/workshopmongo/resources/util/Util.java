package br.com.toshiakibruno.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Util {
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static Date convertDate(String textDate, Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		try {
			return sdf.parse(textDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return defaultValue;
		}
	}
}
