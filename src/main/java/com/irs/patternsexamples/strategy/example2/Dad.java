package com.irs.patternsexamples.strategy.example2;

/**
 * Clase del mienbro de la familia Padre.
 *
 * @author IRS
 * @version 1.0.0
 */
public class Dad extends FamilyMember {

    public Dad() {
        super("Dad", new ActionFlick());
    }
}
