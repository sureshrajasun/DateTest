package com.qantas.common.datediff.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateValidator {
    private DateValidator() {}

    public static boolean isValidDate(String date) {
        if (date == null || date.length() != 10) {
            log.info("Date length is not 10. {}", date);
            return false;
        }

        int day;
        int month;
        int year;

        try {
            year = Integer.parseInt(date.substring(0, 4));
            month = Integer.parseInt(date.substring(5, 7));
            day = Integer.parseInt(date.substring(8));

        } catch (NumberFormatException e) {
            log.error("Exception occurred while parsing the date. {}", e.getMessage());
            return false;
        }

        // Check for year from 1901 to 2999
        if (year < 1901 || year > 2999) {
            return false;
        }

        if (day < 1 || day > 31 || month < 1 || month > 12) {
            return false;
        }

        // Check for February with leap year
        if (month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                return (day <= 29);
            } else {
                return (day <= 28);
            }
        }

        // Check for months with 30 days
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return (day <= 30);
        }

        // All other months have 31 days
        return true;
    }
}
