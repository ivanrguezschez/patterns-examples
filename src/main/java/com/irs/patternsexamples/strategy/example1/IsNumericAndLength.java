package com.irs.patternsexamples.strategy.example1;

/**
 * Implementación de la interface de la estrategia de validación para indicar si
 * es numérico y de una determina longitud.
 *
 * @author IRS
 * @version 1.0.0
 */
public class IsNumericAndLength implements ValidationStrategy {

    private int length;

    public IsNumericAndLength(int l) {
        this.length = l;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean execute(String s) {
        return s.matches(String.format("\\d{%s}", length));
    }
}
