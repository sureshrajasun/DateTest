package com.my.workout.datediff.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DateDifferenceServiceTest {

    @Autowired
    DateDifferenceService dateDifferenceService;

    @Test
    void testDateDifference(){
        assertEquals("19", dateDifferenceService.getDateDifference( "1983-06-02", "1983-06-22" ));
        assertEquals("173", dateDifferenceService.getDateDifference( "1984-07-04", "1984-12-25" ));
        assertEquals("1979", dateDifferenceService.getDateDifference( "1989-01-03", "1983-08-03" ));
        assertEquals("0", dateDifferenceService.getDateDifference( "1972-11-07", "1972-11-08" ));
        assertEquals("1", dateDifferenceService.getDateDifference( "2000-01-01", "2000-01-03" ));
    }
}
