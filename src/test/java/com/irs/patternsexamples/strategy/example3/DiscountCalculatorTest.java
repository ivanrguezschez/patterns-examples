package com.irs.patternsexamples.strategy.example3;

import com.irs.patternsexamples.strategy.example1.IsAllLowerCase;
import com.irs.patternsexamples.strategy.example1.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario para el patrón Strategy de calcular el descuento sin refactorizar.
 *
 *  @author IRS
 *  @version 1.0.0
 */
class DiscountCalculatorTest {

    @Test
    public void testCalculate() {
        DiscountCalculator calculator = new DiscountCalculator();
        double value = calculator.calculate("REGULAR", 100, "FEST10", 1, null);
        //System.out.println("Discount calculated :: " + value);

        assertEquals(20.0, value);
    }
}