package com.irs.patternsexamples.strategy.example3.refactor;

import java.time.LocalDateTime;

public class VipDiscount implements DiscountStrategy {

    public CustomerType type() {
        return CustomerType.VIP;
    }

    public double calculate(double amount, String couponCode, int orderCount, LocalDateTime firstOrderDate) {
        double discount = amount * 0.25;
        if (orderCount > 5 && firstOrderDate.isBefore(LocalDateTime.now().minusYears(2))) {
            discount += 50;
        }
        return discount;
    }
}
