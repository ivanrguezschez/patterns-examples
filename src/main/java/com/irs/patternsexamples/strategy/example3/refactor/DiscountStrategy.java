package com.irs.patternsexamples.strategy.example3.refactor;

import java.time.LocalDateTime;

public interface DiscountStrategy {

    CustomerType type();

    double calculate(double amount, String couponCode, int orderCount, LocalDateTime firstOrderDate);
}
