package com.irs.patternsexamples.strategy.example3.refactor;

import java.time.LocalDateTime;

public class PremiumDiscount implements DiscountStrategy {

    public CustomerType type() {
        return CustomerType.PREMIUM;
    }

    public double calculate(double amount, String couponCode, int orderCount, LocalDateTime firstOrderDate) {
        double discount = amount * 0.15;
        if ("FEST10".equalsIgnoreCase(couponCode)) {
            discount += 20;
        }
        return discount;
    }
}
