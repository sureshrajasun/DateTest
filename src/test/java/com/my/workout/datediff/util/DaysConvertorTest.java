package com.my.workout.datediff.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DaysConvertorTest {

    @Test
    public void testDays() {
        assertEquals(36524, DaysConvertor.getDaysCountFrom1900( 2000,1,1 ));
        assertEquals(1, DaysConvertor.getDaysCountFrom1900( 1900,1,2 ));
    }
}
