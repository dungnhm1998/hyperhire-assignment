package com.demo.assignment.hyperhire.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {

    public static long getDaysDifference(String checkIn, String checkOut) {
        return getDaysDifference(convertStringToDate(checkIn), convertStringToDate(checkOut));
    }

    public static Date addDays(String date, int days) {
        return addDays(convertStringToDate(date), days);
    }

    public static Date convertStringToDate(String dateString) {
        // Parse the ISO 8601 string to an Instant
        Instant instant = Instant.parse(dateString);

        // Convert Instant to Date
        return Date.from(instant);
    }

    public static long getDaysDifference(Date checkIn, Date checkOut) {
        // Convert java.util.Date to LocalDate
        LocalDate checkInDate = checkIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate checkOutDate = checkOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calculate the difference in days
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    public static Date addDays(Date date, int days) {
        // Convert Date to LocalDate
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Add days
        LocalDate modifiedDate = localDate.plusDays(days);

        // Convert LocalDate back to Date
        return Date.from(modifiedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date convertTimeDB(Date date) {
        return date != null ? new Date(date.getTime()) : null;
    }

}
