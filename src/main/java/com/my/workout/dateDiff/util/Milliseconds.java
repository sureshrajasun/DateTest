package com.my.workout.dateDiff.util;

public class Milliseconds {
    public static long getTimeInMillSec(int year, int month, int day) {
        int hour = 0;
        int minute = 0;
        int second = 0;

        // Calculate the number of seconds since the Unix epoch for the given date and time
        int unixSeconds = (int) ((getTimeInSeconds(year, month, day, hour, minute, second) - getTimeInSeconds(1900, 1, 1, 0, 0, 0)));

        // Multiply the number of seconds by 1000 to get the number of milliseconds
        long millis = (long) unixSeconds * 1000;

       // System.out.println("Milliseconds for the given date: " + millis);
        return millis;
    }

    // Calculate the number of seconds since the Unix epoch for the given date and time
    private static int getTimeInSeconds(int year, int month, int day, int hour, int minute, int second) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daysSinceEpoch = 0;

        // Calculate the number of days since the Unix epoch for the given date
        for (int y = 1900; y < year; y++) {
            daysSinceEpoch += isLeapYear(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            daysSinceEpoch += daysInMonth[m - 1];
            if (m == 2 && isLeapYear(year)) {
                daysSinceEpoch++;
            }
        }

        daysSinceEpoch += day - 1;

        // Calculate the number of seconds since the Unix epoch for the given time
        int timeInSeconds = daysSinceEpoch * 24 * 60 * 60 + hour * 60 * 60 + minute * 60 + second;

        return timeInSeconds;
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
