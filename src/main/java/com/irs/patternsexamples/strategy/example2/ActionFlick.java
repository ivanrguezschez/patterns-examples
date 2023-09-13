package com.irs.patternsexamples.strategy.example2;

/**
 * Implementación de la interface de la estrategia de genero de película para indicar
 * las peliculas de acción.
 *
 * @author IRS
 * @version 1.0.0
 */
public class ActionFlick implements MovieGenre {

    @Override
    public String describeABit() {
        return "guns, firing, fights, will chases etc.";
    }
}
