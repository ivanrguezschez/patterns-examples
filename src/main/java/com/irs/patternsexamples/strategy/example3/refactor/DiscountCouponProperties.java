package com.irs.patternsexamples.strategy.example3.refactor;

public class DiscountCouponProperties {

    private static final String FEST10 = "FEST10";

    private String festive;

    public DiscountCouponProperties() {
        this.festive = FEST10;
    }

    public String getFestive() {
        return festive;
    }

    public void setFestive(String festive) {
        this.festive = festive;
    }
}
