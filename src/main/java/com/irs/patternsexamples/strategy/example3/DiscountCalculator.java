package com.irs.patternsexamples.strategy.example3;

import java.time.LocalDateTime;

public class DiscountCalculator {

    public double calculate(String customerType, double amount, String couponCode, int orderCount, LocalDateTime firstOrderDate) {
        double discount = 0;

        if ("REGULAR".equals(customerType)) {
            discount = amount * 0.1;
            if ("FEST10".equalsIgnoreCase(couponCode)) {
                discount += 10;
            }
        } else if ("PREMIUM".equals(customerType)) {
            discount = amount * 0.15;
            if ("FEST10".equalsIgnoreCase(couponCode)) {
                discount += 20;
            }
        } else if ("VIP".equals(customerType)) {
            discount = amount * 0.25;
            if (orderCount > 5 && firstOrderDate.isBefore(LocalDateTime.now().minusYears(2))) {
                discount += 50;
            }
        }

        if (discount > 100) {
            discount = 100; // cap
        }

        //System.out.println("Discount: " + discount);
        return discount;
    }
}
