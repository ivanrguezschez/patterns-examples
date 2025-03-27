package com.irs.patternsexamples.pipeline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test unitario para probar el handler que convierte a minúsculas una entrada.
 *
 *  @author IRS
 *  @version 1.0.0
 */
public class ConvertToLowercaseHandlerTest {

    private final Handler<String, String> convertToLowercaseHandler = new ConvertToLowercaseHandler();

    @Test
    public void testProcess() {
        assertEquals("goyankees!", convertToLowercaseHandler.process("GoYankees!"));
    }
}