package com.irs.patternsexamples.strategy.example3.refactor;

public enum CustomerType {
    REGULAR, PREMIUM, VIP;

    public static CustomerType from(String value) {
        try {
            return CustomerType.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid customer type: " + value);
        }
    }
}
