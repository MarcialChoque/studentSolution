package com.practices.studentsolution.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andresmerida on 9/15/16.
 */
public class DateUtil {

    public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    public static Date getDateYyyyMMddHHmmssFormat(String dateString) {
        Date date;

        try {
            date = DATE_TIME_FORMAT.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Failed to parse date: ", e);
        }

        return date;
    }
}
