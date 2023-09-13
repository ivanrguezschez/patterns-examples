package com.irs.patternsexamples.strategy.example1;

/**
 * Implementación de la interface de la estrategia de validación para indicar si
 * es numérico.
 *
 * @author IRS
 * @version 1.0.0
 */
public class IsNumeric implements ValidationStrategy {

    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}