package com.irs.patternsexamples.strategy.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario para el patrón Strategy de validación.
 *
 *  @author IRS
 *  @version 1.0.0
 */
class ValidatorTest {

    @Test
    public void testIsAllLowerCaseStrategy() {
        Validator validator = new Validator(new IsAllLowerCase());
        assertTrue(validator.validate("aaaa"));
        assertFalse(validator.validate("AAAA"));
    }

    @Test
    public void testIsAllUpperCaseStrategy() {
        Validator validator = new Validator(new IsAllUpperCase());
        assertFalse(validator.validate("aaaa"));
        assertTrue(validator.validate("AAAA"));
    }

    @Test
    public void testIsNumericStrategy() {
        Validator validator = new Validator(new IsNumeric());
        assertFalse(validator.validate("aaaa"));
        assertTrue(validator.validate("1234"));
        assertTrue(validator.validate("0000"));
        assertFalse(validator.validate("12.45"));
        assertTrue(validator.validate(String.valueOf(new Integer(1))));
    }

    @Test
    public void testIsNumericAndLengthStrategy() {
        Validator validator = new Validator(new IsNumericAndLength(5));
        assertTrue(validator.validate("28045"));
        assertFalse(validator.validate("1234"));
        assertFalse(validator.validate("0000"));
        assertFalse(validator.validate("12.45"));
        assertTrue(validator.validate("00000"));
    }
}