package com.irs.patternsexamples.singleton;

/**
 * Clase principal del patron Singleton.
 *
 * @author IRS
 * @version 1.0.0
 */
public class MainMySingleton {
    public static void main(String[] args) {
        MySingleton mySingleton1 = MySingleton.getInstance();
        MySingleton mySingleton2 = MySingleton.getInstance();

        System.out.printf("Valor del contador 1: %1$d\n", mySingleton1.getContador());
        System.out.printf("Valor del contador 2: %1$d\n", mySingleton2.getContador());

        System.out.printf("Incremento, valor del contador 1: %1$d\n", mySingleton1.incrementar());
        System.out.printf("Incremento, valor del contador 2: %1$d\n", mySingleton2.incrementar());
        System.out.printf("Incremento, valor del contador 1: %1$d\n", mySingleton1.incrementar());
        System.out.printf("Incremento, valor del contador 2: %1$d\n", mySingleton2.incrementar());
    }
}
