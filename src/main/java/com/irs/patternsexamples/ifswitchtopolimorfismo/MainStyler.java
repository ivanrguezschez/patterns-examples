package com.irs.patternsexamples.ifswitchtopolimorfismo;

/**
 * Ejemplo para sustituir una sentencia switch o if-else multiple mediante
 * polimorfismo (Patrón estrategia)
 *
 * @author IRS
 * @version 1.0.0
 */
public class MainStyler {

    public static void main(String[] args) {
        System.out.println("Ejemplo con switch");
        StylerSwitch stylerSwitch = new StylerSwitch();
        System.out.println("->" +  stylerSwitch.setStyle("hola", Styles.Bold));

        System.out.println("Ejemplo con polimorfismo (Patron estrategia)");
        StylerPolimorfismo stylerPolimorfismo = new StylerPolimorfismo();
        System.out.println("->" +  stylerPolimorfismo.setStyle("hola", new BoldStyler()));
    }
}
