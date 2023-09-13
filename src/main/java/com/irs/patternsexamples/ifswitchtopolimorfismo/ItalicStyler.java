package com.irs.patternsexamples.ifswitchtopolimorfismo;

/**
 * Implementación del interface del estilo para cursiva.
 *
 * @author IRS
 * @version 1.0.0
 */
public class ItalicStyler implements IStyler {

    public ItalicStyler() {
    }

    public String setStyle(String input) {
        return "<i>" + input + "</i>";
    }
}
