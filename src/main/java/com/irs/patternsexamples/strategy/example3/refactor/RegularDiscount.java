package com.irs.patternsexamples.strategy.example3.refactor;

import java.time.LocalDateTime;

public class RegularDiscount implements DiscountStrategy {

    public CustomerType type() {
        return CustomerType.REGULAR;
    }

    public double calculate(double amount, String couponCode, int orderCount, LocalDateTime firstOrderDate) {
        double discount = amount * 0.1;
        if ("FEST10".equalsIgnoreCase(couponCode)) {
            discount += 10;
        }
        return discount;
    }
}
