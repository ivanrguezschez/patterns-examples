package com.irs.patternsexamples.pipeline;

import java.util.List;

public class MainPipeline {

    public static void main(String[] args) {
        System.out.println("Creando pipeline");
        Pipeline<String, List<Character>> filters = new Pipeline<>(new RemoveDigitsHandler())
                .addHandler(new ConvertToLowercaseHandler())
                .addHandler(new ConvertToCharListHandler());

        String input = "GoYankees123!";
        System.out.printf("Ejecutando pipeline con la entrada: %s\n", input);
        List<Character> characters = filters.execute(input);

        System.out.println("Salida del pipeline");
        characters.forEach(System.out::print);
    }
}
