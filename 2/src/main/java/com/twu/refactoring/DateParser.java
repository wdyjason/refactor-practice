package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();
    private int year;
    private int month;
    private int date;
    private int hour;
    private int minute;

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        year = parseString(0, 4, "Year", "4");
        if (year < 2000 || year > 2012)
            throw new IllegalArgumentException("Year cannot be less than 2000 or more than 2012");

        month = parseString(5, 7, "Month", "2");
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Month cannot be less than 1 or more than 12");

        date = parseString(8, 10, "Date", "2");
        if (date < 1 || date > 31)
            throw new IllegalArgumentException("Date cannot be less than 1 or more than 31");

        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {

            hour = parseString(11, 13, "Hour", "2");
            if (hour < 0 || hour > 23)
                throw new IllegalArgumentException("Hour cannot be less than 0 or more than 23");

            minute = parseString(14, 16, "Minute", "2");
            if (minute < 0 || minute > 59)
                throw new IllegalArgumentException("Minute cannot be less than 0 or more than 59");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public int parseString(int startIndex, int endIndex, String type, String expectLen) {
        Integer result = 0;
        try {
            result = Integer.parseInt(dateAndTimeString.substring(startIndex, endIndex));
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(type + " string is less than " + expectLen + " characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(type + " is not an integer");
        }
        return result;
    }
}
