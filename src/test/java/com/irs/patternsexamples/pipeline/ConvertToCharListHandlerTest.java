package com.irs.patternsexamples.pipeline;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test unitario para probar el handler que convierte a una lista de caracteres una entrada.
 *
 *  @author IRS
 *  @version 1.0.0
 */
public class ConvertToCharListHandlerTest {

    private final Handler<String, List<Character>> convertToCharListHandler = new ConvertToCharListHandler();

    @Test
    public void testProcess() {
        List<Character> expected = List.of('g', 'o', 'y', 'a', 'n', 'k', 'e', 'e', 's', '!');
        List<Character> actual = convertToCharListHandler.process("goyankees!");

        assertEquals(expected.size(), actual.size());

        int index = 0;
        for (Character c : expected) {
            assertEquals(c, actual.get(index++));
        }
    }
}