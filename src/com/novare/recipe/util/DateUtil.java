package com.novare.recipe.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Date;

public final class DateUtil {

	private final static String DATE_FORMAT_PATTERN = "dd-MM-yyyy";

	public static Integer getWeekNumber(int year, int month, int day) {
		LocalDate date = LocalDate.of(year, month, day);
		int weekOfYear = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
		return weekOfYear;
	}

	public static Integer getWeekNumberNow() {
		LocalDate date = LocalDate.now();
		int weekOfYear = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
		return weekOfYear;
	}

	public static Date getDate(String dateAsString) throws ParseException {
		return new SimpleDateFormat(DATE_FORMAT_PATTERN).parse(dateAsString);
	}

	public static String getNow() throws ParseException {
		return new SimpleDateFormat(DATE_FORMAT_PATTERN).format(new Date());
	}
}
