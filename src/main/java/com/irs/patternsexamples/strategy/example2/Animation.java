package com.irs.patternsexamples.strategy.example2;

/**
 * Implementación de la interface de la estrategia de genero de película para indicar
 * las peliculas de animación.
 *
 * @author IRS
 * @version 1.0.0
 */
public class Animation implements MovieGenre {

    @Override
    public String describeABit() {
        return "cartoons! What else?";
    }
}
