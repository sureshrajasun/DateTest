package com.my.workout.dateDiff.service;

import com.my.workout.dateDiff.bean.AppDate;
import com.my.workout.dateDiff.exception.DateDifferenceException;
import com.my.workout.dateDiff.util.DateValidator;
import com.my.workout.dateDiff.util.Milliseconds;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DateDifferenceService {

    public String getDateDifference(String startDate, String endDate) {

        boolean isDatesInvalid = false;
        StringBuilder errorMessage = new StringBuilder();

        if(!DateValidator.isValidDate(startDate)){
            log.error("Start Date '{}' is not valid.",startDate);
            isDatesInvalid = true;
            errorMessage.append(String.format(" Start Date '%s' is not valid. ",startDate));
        }
        if(!DateValidator.isValidDate(endDate)) {
            log.error("End Date '{}' is not valid. ", endDate);
            isDatesInvalid = true;
            errorMessage.append(String.format(" End Date '%s' is not valid.", endDate));
        }

        if(isDatesInvalid){
            throw new DateDifferenceException(errorMessage.toString());
        }


        int diffInDays = getDiffInDays(convertToDate(startDate), convertToDate(endDate));

        log.info("Difference between dates: {} days", diffInDays);

        return String.valueOf(diffInDays);
    }

    private static AppDate convertToDate(String startDate) {
        int year = Integer.parseInt(startDate.substring(0, 4));
        int month = Integer.parseInt(startDate.substring(5, 7));
        int day = Integer.parseInt(startDate.substring(8));

        log.info("Year :{}", year );
        log.info("Month :{}", month );
        log.info("Day :{}", day );
        return new AppDate(year, month, day);
    }

    public static int getDiffInDays(AppDate appDate1, AppDate appDate2) {

        // Calculate the difference between the dates in milliseconds
        long diffInMillis = Milliseconds.getTimeInMillSec(appDate2.getYear(), appDate2.getMonth(), appDate2.getDay()) -
                Milliseconds.getTimeInMillSec(appDate1.getYear(), appDate1.getMonth(), appDate1.getDay());

        // Calculate the difference in days
        int diffInDays = ((int) (diffInMillis / (24 * 60 * 60 * 1000))) - 1;

        diffInDays =  diffInDays < 0 ? -diffInDays : diffInDays;
        return diffInDays;
    }
}
