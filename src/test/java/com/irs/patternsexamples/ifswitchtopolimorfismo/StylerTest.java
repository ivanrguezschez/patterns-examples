package com.irs.patternsexamples.ifswitchtopolimorfismo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario para sustituir una sentencia switch o if-else multiple mediante
 * polimorfismo (Patrón estrategia)
 *
 *  @author IRS
 *  @version 1.0.0
 */
public class StylerTest {

    private StylerSwitch stylerSwitch = new StylerSwitch();

    private StylerPolimorfismo stylerPolimorfismo = new StylerPolimorfismo();

    @Test
    public void testBoldStyle() {
        assertEquals("<b>hola</b>", stylerSwitch.setStyle("hola", Styles.Bold));
        assertEquals("<b>hola</b>", stylerPolimorfismo.setStyle("hola", new BoldStyler()));
    }

    @Test
    public void testItalicStyle() {
        assertEquals("<i>hola</i>", stylerSwitch.setStyle("hola", Styles.Italic));
        assertEquals("<i>hola</i>", stylerPolimorfismo.setStyle("hola", new ItalicStyler()));
    }

    @Test
    public void testUnderlineStyle() {
        assertEquals("<u>hola</u>", stylerSwitch.setStyle("hola", Styles.Underline));
        assertEquals("<u>hola</u>", stylerPolimorfismo.setStyle("hola", new UnderlineStyler()));
    }
}
