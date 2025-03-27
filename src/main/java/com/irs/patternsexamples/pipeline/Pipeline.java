package com.irs.patternsexamples.pipeline;

public class Pipeline<I, O> {

    private final Handler<I, O> currentHandler;

    public Pipeline(Handler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }

    public <K> Pipeline<I, K> addHandler(Handler<O, K> newHandler) {
        System.out.printf("Añadiendo handler %s\n", newHandler.getClass().getName());
        return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
    }

    public O execute(I input) {
        return currentHandler.process(input);
    }
}
