package com.putoet.kata01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightPricingSchemeTest {

    @Test
    void price() {
        final double pricePerUnit = 10.0;
        final int units = 5;
        final WeightPricingScheme scheme = new WeightPricingScheme(pricePerUnit);
        assertEquals(50.0, scheme.price(units));
    }

    @Test
    void priceWith10PercentDiscount() {
        final double pricePerUnit = 10.0;
        final int units = 5;
        final WeightPricingScheme scheme = new WeightPricingScheme(pricePerUnit)
                .discountScheme((pricePerUnit1, units1) -> pricePerUnit1 * 0.1 * units1);
        assertEquals(45.0, scheme.price(units));
    }

    @Test
    void priceWith2ForFreeWIth4OrMoreDiscount() {
        final double pricePerUnit = 10.0;
        final int units = 5;
        final WeightPricingScheme scheme = new WeightPricingScheme(pricePerUnit)
                .discountScheme((pricePerUnit1, units1) -> units1 > 4 ? pricePerUnit1 * 2 : 0.0);
        assertEquals(30.0, scheme.price(units));
    }

    @Test
    void pricePerUnit() {
        final double pricePerUnit = 10.0;
        final NumberPricingScheme scheme = new NumberPricingScheme(pricePerUnit);
        assertEquals(pricePerUnit, scheme.pricePerUnit());
    }
}