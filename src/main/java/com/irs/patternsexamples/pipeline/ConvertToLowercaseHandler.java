package com.irs.patternsexamples.pipeline;

public class ConvertToLowercaseHandler implements Handler<String, String> {

    @Override
    public String process(String input) {
        System.out.println("ConvertToLowercaseHandler process");
        return input.toLowerCase();
    }
}
