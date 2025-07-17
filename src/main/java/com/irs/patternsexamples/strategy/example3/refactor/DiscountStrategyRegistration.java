package com.irs.patternsexamples.strategy.example3.refactor;

import java.time.LocalDateTime;

public class DiscountStrategyRegistration {

    public static StrategyRegistry<CustomerType, DiscountRequest> createRegistry() {
        StrategyRegistry<CustomerType, DiscountRequest> registry = new StrategyRegistry<>();

        DiscountCouponProperties couponProperties = new DiscountCouponProperties();

        registry.register(CustomerType.REGULAR, req -> {
            double discount = req.getAmount() * 0.1;
            if (couponProperties.getFestive().equalsIgnoreCase(req.getCouponCode())) {
                discount += 10;
            }
            return discount;
        });

        registry.register(CustomerType.PREMIUM, req -> {
            double discount = req.getAmount() * 0.15;
            if (couponProperties.getFestive().equalsIgnoreCase(req.getCouponCode())) {
                discount += 20;
            }
            return discount;
        });

        registry.register(CustomerType.VIP, req -> {
            double discount = req.getAmount() * 0.25;
            if (req.getOrderCount() > 5 && req.getFirstOrderDate().isBefore(LocalDateTime.now().minusYears(2))) {
                discount += 50;
            }
            return discount;
        });

        return registry;
    }
}
