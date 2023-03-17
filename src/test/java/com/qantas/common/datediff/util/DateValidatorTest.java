package com.qantas.common.datediff.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DateValidatorTest {

    @Test
    void testValidDates() {

        assertTrue( DateValidator.isValidDate( "1982-01-01" ) );
        assertTrue( DateValidator.isValidDate( "2000-02-29" ) );
        assertTrue( DateValidator.isValidDate( "2024-02-29" ) );
        assertTrue( DateValidator.isValidDate( "1901-12-31" ) );
        assertTrue( DateValidator.isValidDate( "2200-01-01" ) );

    }

    @Test
    void testInValidDates() {

        assertFalse( DateValidator.isValidDate( "198-01-01" ) );
        assertFalse( DateValidator.isValidDate( "A000-02-29" ) );
        assertFalse( DateValidator.isValidDate( "2024-02" ) );
        assertFalse( DateValidator.isValidDate( "1901-12-33" ) );
        assertFalse( DateValidator.isValidDate( "2200-22-01" ) );

    }

}
