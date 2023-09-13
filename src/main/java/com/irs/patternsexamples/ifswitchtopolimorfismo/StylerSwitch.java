package com.irs.patternsexamples.ifswitchtopolimorfismo;

/**
 * Clase de ejemplo con switch.
 *
 * @author IRS
 * @version 1.0.0
 */
public class StylerSwitch {

    public String setStyle(String input, Styles style) {
        switch (style) {
            case Bold:
                return "<b>" + input + "</b>";
            case Italic:
                return "<i>" + input + "</i>";
            case Underline:
                return "<u>" + input + "</u>";
            default:
                throw new IllegalArgumentException("Invalid style type: " + style);
        }
    }
}
