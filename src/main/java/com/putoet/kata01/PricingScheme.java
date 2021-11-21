package com.putoet.kata01;

public abstract class PricingScheme {
    public abstract double price(int units);
    public abstract double pricePerUnit();

    public double priceWithoutDiscount(int units) {
        return units * pricePerUnit();
    }
}
