package com.irs.patternsexamples.strategy.example1;

/**
 * Clase principal del patron strategy de validación.
 *
 * @author IRS
 * @version 1.0.0
 */
public class MainValidator {
    public static void main(String[] args) {
        Validator v1 = new Validator(new IsNumeric());
        System.out.println("aaaa is numeric: " + v1.validate("aaaa"));
        System.out.println("1234 is numeric: " + v1.validate("1234"));
        System.out.println("0000 is numeric: " + v1.validate("0000"));
        System.out.println("12.45 is numeric: " + v1.validate("12.45"));
        System.out.println("1 is numeric: " + v1.validate(String.valueOf(new Integer(1))));

        Validator v2 = new Validator(new IsAllLowerCase());
        System.out.println("bbbb is all lower case: " + v2.validate("bbbb"));

        Validator v3 = new Validator(new IsAllUpperCase());
        System.out.println("bbbb is all upper case: " + v3.validate("bbbb"));
        System.out.println("BBBB is all upper case: " + v3.validate("BBBB"));

        // Por ejemplo para el código postal que son 5 numeros
        Validator v4 = new Validator(new IsNumericAndLength(5));
        System.out.println("28045 is numeric and length: " + v4.validate("28045"));
        System.out.println("1234 is numeric and length: " + v4.validate("1234"));
        System.out.println("abcde is numeric and length: " + v4.validate("abcde"));
        System.out.println("00000 is numeric and length: " + v4.validate("00000"));
    }
}
