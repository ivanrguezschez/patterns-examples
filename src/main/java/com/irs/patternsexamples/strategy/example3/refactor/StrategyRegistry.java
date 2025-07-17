package com.irs.patternsexamples.strategy.example3.refactor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class StrategyRegistry <T, R> {

    private final Map<T, Function<R, Double>> strategies = new HashMap<>();

    public void register(T key, Function<R, Double> strategyFunc) {
        strategies.put(key, strategyFunc);
    }

    public double apply(T key, R request) {
        return strategies.getOrDefault(key, r -> 0.0).apply(request);
    }
}
