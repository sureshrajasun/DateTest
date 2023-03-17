package com.my.workout.datediff.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DaysConvertor {

    private DaysConvertor() {}

    public static int getDaysCountFrom1900(int year, int month, int day) {

        // Calculate the number of numberOfDaysFrom1900 since the 1900 Jan 1st for the given date and time
        int numberOfDaysFrom1900 = (getNumberOfDays( year,
                                        month,
                                        day ) - getNumberOfDays( 1900,
                                                                 1,
                                                                 1 ));

        log.info("Number of days since 1900 JAN 1st: {} ", numberOfDaysFrom1900);

        return numberOfDaysFrom1900;
    }

    // Calculate the number of seconds since 1900 Jan 1st for the given date and time
    private static int getNumberOfDays(int year, int month, int day) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daysSince1900Jan1st = 0;

        // Calculate the number of days since the 1900 Jan 1st for the given date
        for (int y = 1900; y < year; y++) {
            daysSince1900Jan1st += isLeapYear(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            daysSince1900Jan1st += daysInMonth[m - 1];
            if (m == 2 && isLeapYear(year)) {
                daysSince1900Jan1st++;
            }
        }

        daysSince1900Jan1st += day - 1;

        return daysSince1900Jan1st;
    }

    // Check if a year is a leap year
    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
