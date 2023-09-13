package com.irs.patternsexamples.strategy.example2;

/**
 * Implementación de la interface de la estrategia de genero de película para indicar
 * las peliculas romanticas.
 *
 * @author IRS
 * @version 1.0.0
 */
public class RomanticMovie implements MovieGenre {

    @Override
    public String describeABit() {
        return "some romantic flick";
    }
}
