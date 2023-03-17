package com.my.workout.datediff.util;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DateValidatorTest {

    @Test
    public void testValidDates() {

        assertEquals(true, DateValidator.isValidDate( "1982-01-01"));
        assertEquals(true, DateValidator.isValidDate( "2000-02-29"));
        assertEquals(true, DateValidator.isValidDate( "2024-02-29"));
        assertEquals(true, DateValidator.isValidDate( "1901-12-31"));
        assertEquals(true, DateValidator.isValidDate( "2200-01-01"));

    }

    @Test
    public void testInValidDates() {

        assertEquals(false, DateValidator.isValidDate( "198-01-01"));
        assertEquals(false, DateValidator.isValidDate( "A000-02-29"));
        assertEquals(false, DateValidator.isValidDate( "2024-02"));
        assertEquals(false, DateValidator.isValidDate( "1901-12-33"));
        assertEquals(false, DateValidator.isValidDate( "2200-22-01"));

    }

}
