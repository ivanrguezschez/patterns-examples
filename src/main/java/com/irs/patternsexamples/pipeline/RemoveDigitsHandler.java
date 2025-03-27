package com.irs.patternsexamples.pipeline;

public class RemoveDigitsHandler implements Handler<String, String> {

    @Override
    public String process(String input) {
        System.out.println("RemoveDigitsHandler process");
        return input.replaceAll("\\d", "");
    }
}
