package com.irs.patternsexamples.strategy.example3.refactor;

import com.irs.patternsexamples.strategy.example3.DiscountCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario para el patrón Strategy de calcular el descuento con refactorización.
 *
 *  @author IRS
 *  @version 1.0.0
 */
class DiscountCalculatorRefactorTest {

    @Test
    public void testCalculate() {
        DiscountCalculatorRefactor calculator = new DiscountCalculatorRefactor(DiscountStrategyRegistration.createRegistry());
        double value = calculator.calculate("REGULAR",100,"FEST10",1,null);
        //System.out.println("Discount calculated :: " + value);

        assertEquals(20.0, value);
    }

}