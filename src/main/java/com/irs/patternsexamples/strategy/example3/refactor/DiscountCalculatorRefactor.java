package com.irs.patternsexamples.strategy.example3.refactor;

import java.time.LocalDateTime;

public class DiscountCalculatorRefactor {

    private final StrategyRegistry<CustomerType, DiscountRequest> registry;

    public DiscountCalculatorRefactor(StrategyRegistry<CustomerType, DiscountRequest> registry) {
        this.registry = registry;
    }

    public double calculate(String customerTypeStr, double amount, String couponCode, int orderCount, LocalDateTime firstOrderDate) {
        CustomerType type = CustomerType.from(customerTypeStr);
        DiscountRequest req = new DiscountRequest(amount, couponCode, orderCount, firstOrderDate);
        return Math.min(100, registry.apply(type, req));
    }
}
