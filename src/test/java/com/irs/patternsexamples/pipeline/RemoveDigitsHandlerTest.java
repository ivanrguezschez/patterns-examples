package com.irs.patternsexamples.pipeline;

import com.irs.patternsexamples.ifswitchtopolimorfismo.BoldStyler;
import com.irs.patternsexamples.ifswitchtopolimorfismo.StylerSwitch;
import com.irs.patternsexamples.ifswitchtopolimorfismo.Styles;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario para probar el handler que elimina los números de una entrada.
 *
 *  @author IRS
 *  @version 1.0.0
 */
public class RemoveDigitsHandlerTest {

    private final Handler<String, String> removeDigitsHandler = new RemoveDigitsHandler();

    @Test
    public void testProcess() {
        assertEquals("GoYankees!", removeDigitsHandler.process("GoYankees123!"));
    }
}