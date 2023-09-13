package com.irs.patternsexamples.singleton;

/**
 * Clase Singleton. Solo habr&aacute; una instancia (objeto) en la JVM.
 *
 * @author IRS
 * @version 1.0.0
 *
 * Ejemplo:
 * Ahora con 10 instancias, habria 10 objetos que comparten la variable static 'instances'.
 *
 * private static MySingleton[] instances = null;
 *
 * private MySingleton() { this.contador = 0; }
 *
 * public static MySingleton getInstance() {
 * 		// Inicializar el array y seleccionar una libre
 * 		if (...) {
 * 			synchronized(MySingleton.class) {
 * 				...
 *            }
 *        }
 *
 * 		return instances[i];
 * }
 */
public class MySingleton {
    private static MySingleton instance = null;

    private int contador;

    private MySingleton() {
        this.contador = 0;
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            synchronized(MySingleton.class) {
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }

        return instance;
    }

    public synchronized int getContador() {
        return contador;
    }

    /*
    public synchronized int incrementar() {
        return contador++;
    }
    */

    public synchronized int incrementar() {
        return ++contador;
    }
}
