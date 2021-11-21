package com.putoet.kata01;

import java.util.Optional;

public class WeightPricingScheme extends PricingScheme {
    public double pricePerUnitWeight;
    private Optional<WeightDiscountScheme> discountScheme;

    public WeightPricingScheme(double pricePerUnitWeight) {
        this.pricePerUnitWeight = pricePerUnitWeight;
        discountScheme = Optional.empty();
    }

    @Override
    public double price(int units) {
        final double discount = discountScheme.map(numberDiscountScheme -> numberDiscountScheme.discount(pricePerUnitWeight, units)).orElse(0.0);
        return units * pricePerUnitWeight - discount;
    }

    @Override
    public double pricePerUnit() {
        return pricePerUnitWeight;
    }

    public Optional<WeightDiscountScheme> discountScheme() {return discountScheme; }
    public WeightPricingScheme discountScheme(WeightDiscountScheme discountScheme) {
        this.discountScheme = Optional.of(discountScheme);
        return this;
    }
}
