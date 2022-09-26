package com.anchtun.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtility {

	private static String YYYY_MM_DD_PATTERN = "yyyy-MM-dd";

	public static String nowToString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_PATTERN);
		return LocalDate.now().format(formatter);
	}

}
