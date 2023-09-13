package com.irs.patternsexamples.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario para el patrón Singleton.
 *
 *  @author IRS
 *  @version 1.0.0
 */
class MySingletonTest {

    MySingleton mySingleton1 = MySingleton.getInstance();
    MySingleton mySingleton2 = MySingleton.getInstance();

    @Test
    public void testIncrementar() {
        assertEquals(0, mySingleton1.getContador());
        assertEquals(0, mySingleton2.getContador());

        assertEquals(1, mySingleton1.incrementar());
        assertEquals(1, mySingleton1.getContador());
        assertEquals(1, mySingleton2.getContador());

        assertEquals(2, mySingleton2.incrementar());
        assertEquals(2, mySingleton1.getContador());
        assertEquals(2, mySingleton2.getContador());

        assertEquals(3, mySingleton1.incrementar());
        assertEquals(3, mySingleton1.getContador());
        assertEquals(3, mySingleton2.getContador());

        assertEquals(4, mySingleton2.incrementar());
        assertEquals(4, mySingleton1.getContador());
        assertEquals(4, mySingleton2.getContador());
    }
}