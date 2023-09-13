package com.irs.patternsexamples.strategy.example1;

/**
 * Implementación de la interface de la estrategia de validación para indicar si
 * es una cadena en minúsculas.
 *
 * @author IRS
 * @version 1.0.0
 */
public class IsAllLowerCase implements ValidationStrategy {

    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
