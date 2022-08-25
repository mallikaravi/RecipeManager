package com.novare.recipe.util;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DateUtil {

	private final static String DATE_FORMAT_PATTERN = "dd-MM-yyyy";
	private final static String DATE_DAY_FORMAT_PATTERN = "EEEE yyyy-MM-dd";

	public static LocalDate toLocalDate(Date date) {
		return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	public static Date toDate(LocalDate date) {
		return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static Integer getWeekNumberOn(LocalDate date) {
		int weekOfYear = date.get(WeekFields.of(date.getDayOfWeek(), 2).weekOfYear());
		return weekOfYear;
	}

	public static Integer getWeekNumberNow() {
		return getWeekNumberOn(LocalDate.now());
	}

	public static int getDayNumber(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return day.getValue();
	}

	public static String getDayString(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return day.getDisplayName(TextStyle.FULL, Locale.getDefault());
	}

	public static List<String> getWeekDays() {
		List<String> weekDays = new ArrayList<>();
		for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
			String format = String.format("%-9s %-10s", dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()),
					LocalDate.now().with(dayOfWeek));
			weekDays.add(format);
		}
		return weekDays;
	}

	public static LocalDate toDate(String dateAsString) throws ParseException {
		return LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
	}
	
	public static LocalDate toDateWithDay(String dateAsString) throws ParseException {
		return LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern(DATE_DAY_FORMAT_PATTERN));
	}

	public static String toString(LocalDate date) throws ParseException {
		return date.format(DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
	}

	public static String getNow() throws ParseException {
		return toString(LocalDate.now());
	}
}
