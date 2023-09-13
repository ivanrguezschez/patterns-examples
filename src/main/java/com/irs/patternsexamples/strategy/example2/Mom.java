package com.irs.patternsexamples.strategy.example2;

/**
 * Clase del mienbro de la familia Madre.
 *
 * @author IRS
 * @version 1.0.0
 */
public class Mom extends FamilyMember {

    public Mom() {
        super("Mom", new RomanticMovie());
    }
}
