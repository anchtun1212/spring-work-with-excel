package com.anchtun.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtility {

	private static String YYYY_MM_DD_HH_MM_SS_PATTERN = "yyyy-MM-dd_HH-mm-ss";

	public static String nowToString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS_PATTERN);
		return LocalDateTime.now().format(formatter);
	}

	public static void main(String[] args) {
		System.out.println(nowToString());
	}
}
