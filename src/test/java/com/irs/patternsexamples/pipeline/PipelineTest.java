package com.irs.patternsexamples.pipeline;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test unitario para probar el pipeline con tres handler que convierte a una lista de caracteres una entrada elimiando
 * los números y convirtiendo cada caracter a minúsculas.
 *
 *  @author IRS
 *  @version 1.0.0
 */
class PipelineTest {

    private final Pipeline<String, List<Character>> filters = new Pipeline<>(new RemoveDigitsHandler())
            .addHandler(new ConvertToLowercaseHandler())
            .addHandler(new ConvertToCharListHandler());

    @Test
    public void testExecute() {
        List<Character> expected = List.of('g', 'o', 'y', 'a', 'n', 'k', 'e', 'e', 's', '!');
        String input = "GoYankees123!";
        List<Character> actual = filters.execute(input);

        StringBuilder sb = new StringBuilder();
        actual.forEach(sb::append);
        assertEquals("goyankees!", sb.toString());

        int index = 0;
        for (Character c : expected) {
            assertEquals(c, actual.get(index++));
        }
    }
}