package com.irs.patternsexamples.pipeline;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConvertToCharListHandler implements Handler<String, List<Character>> {

    @Override
    public List<Character> process(String input) {
        System.out.println("ConvertToCharListHandler process");
        return Arrays.stream(input.split(""))
                .map(it -> it.charAt(0))
                .collect(Collectors.toList());
    }
}
