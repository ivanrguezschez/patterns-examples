package com.irs.patternsexamples.strategy.example2;

/**
 * Clase principal del patron strategy de generos de películas y miembros de familia.
 *
 * @author IRS
 * @version 1.0.0
 */
public class MainDriver {

    public static void main(String[] args) {
        FamilyMember[] allInTheFamily = new FamilyMember[] {
                new Dad(),
                new Mom(),
                new Kid()
        };

        for (FamilyMember familyMember : allInTheFamily) {
            familyMember.letUsGoForAMovie();
        }
    }
}
