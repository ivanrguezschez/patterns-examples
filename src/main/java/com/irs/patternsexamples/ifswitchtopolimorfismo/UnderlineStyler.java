package com.irs.patternsexamples.ifswitchtopolimorfismo;

/**
 * Implementación del interface del estilo para subrayado.
 *
 * @author IRS
 * @version 1.0.0
 */
public class UnderlineStyler implements IStyler {

    public UnderlineStyler() {
    }

    public String setStyle(String input) {
        return "<u>" + input + "</u>";
    }
}
