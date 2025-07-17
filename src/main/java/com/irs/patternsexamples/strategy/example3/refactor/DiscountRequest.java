package com.irs.patternsexamples.strategy.example3.refactor;

import java.time.LocalDateTime;

public class DiscountRequest {

    private double amount;

    private String couponCode;

    private int orderCount;

    private LocalDateTime firstOrderDate;

    public DiscountRequest(double amount, String couponCode, int orderCount, LocalDateTime firstOrderDate) {
        this.amount = amount;
        this.couponCode = couponCode;
        this.orderCount = orderCount;
        this.firstOrderDate = firstOrderDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public LocalDateTime getFirstOrderDate() {
        return firstOrderDate;
    }

    public void setFirstOrderDate(LocalDateTime firstOrderDate) {
        this.firstOrderDate = firstOrderDate;
    }
}
