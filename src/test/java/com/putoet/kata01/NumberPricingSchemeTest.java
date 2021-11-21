package com.putoet.kata01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberPricingSchemeTest {

    @Test
    void price() {
        final double pricePerUnit = 10.0;
        final int units = 5;
        final NumberPricingScheme scheme = new NumberPricingScheme(pricePerUnit);
        assertEquals(50.0, scheme.price(units));
    }

    @Test
    void priceWith10PercentDiscount() {
        final double pricePerUnit = 10.0;
        final int units = 5;
        final NumberPricingScheme scheme = new NumberPricingScheme(pricePerUnit)
                .discountScheme((pricePerUnit1, units1) -> pricePerUnit1 * 0.1 * units1);
        assertEquals(45.0, scheme.price(units));
    }

    @Test
    void priceWith3rdForFreeDiscount() {
        final double pricePerUnit = 10.0;
        final int units = 5;
        final NumberPricingScheme scheme = new NumberPricingScheme(pricePerUnit)
                .discountScheme((pricePerUnit1, units1) -> pricePerUnit1 * Math.floor(units1 / 3.0));
        assertEquals(40.0, scheme.price(units));
    }

    @Test
    void pricePerUnit() {
        final double pricePerUnit = 10.0;
        final NumberPricingScheme scheme = new NumberPricingScheme(pricePerUnit);
        assertEquals(pricePerUnit, scheme.pricePerUnit());
    }
}