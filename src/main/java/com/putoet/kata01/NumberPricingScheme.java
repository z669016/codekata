package com.putoet.kata01;

import java.util.Optional;

public class NumberPricingScheme extends PricingScheme {
    public double pricePerUnit;
    private Optional<NumberDiscountScheme> discountScheme;

    public NumberPricingScheme(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        discountScheme = Optional.empty();
    }

    @Override
    public double price(int units) {
        final double discount = discountScheme.map(numberDiscountScheme -> numberDiscountScheme.discount(pricePerUnit, units)).orElse(0.0);
        return units * pricePerUnit - discount;
    }

    @Override
    public double pricePerUnit() {
        return pricePerUnit;
    }

    public Optional<NumberDiscountScheme> discountScheme() {return discountScheme; }
    public NumberPricingScheme discountScheme(NumberDiscountScheme discountScheme) {
        this.discountScheme = Optional.of(discountScheme);
        return this;
    }
}
