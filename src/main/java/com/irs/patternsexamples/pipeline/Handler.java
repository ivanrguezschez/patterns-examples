package com.irs.patternsexamples.pipeline;

public interface Handler<I, O> {
    O process (I input);
}
