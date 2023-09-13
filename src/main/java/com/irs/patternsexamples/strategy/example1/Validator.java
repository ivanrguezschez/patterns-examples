package com.irs.patternsexamples.strategy.example1;

/**
 * Clase que ejecuta la estrategia de validación correspodiente.
 *
 * @author IRS
 * @version 1.0.0
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy v) {
        this.strategy = v;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }
}
