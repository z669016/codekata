package com.putoet.kata01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {
    private Orders orders;

    @BeforeEach
    void setup() {
        orders = new Orders();
    }

    @Test
    void add() {
        assertEquals(0, orders.orderLines().size());
        orders.add(ArticleTest.JELLY, 5);
        assertEquals(1, orders.orderLines().size());
        orders.add(ArticleTest.POTATOES, 5);
        orders.add(ArticleTest.JELLY, 2);
        assertEquals(2, orders.orderLines().size());
        assertEquals(7, orders.orderLines().get(0).getValue1());
    }

    @Test
    void remove() {
        orders.add(ArticleTest.JELLY, 7);
        assertEquals(1, orders.orderLines().size());
        orders.add(ArticleTest.POTATOES, 5);
        orders.remove(ArticleTest.JELLY, 2);
        orders.remove(ArticleTest.POTATOES, 5);
        assertEquals(1, orders.orderLines().size());
        assertEquals(5, orders.orderLines().get(0).getValue1());

        // removing an article not in the list is fine
        orders.remove(ArticleTest.MILK, 1);

        // removing too much is not allowed though
        assertThrows(IllegalArgumentException.class,() -> orders.remove(ArticleTest.JELLY, 6));
    }

    @Test
    void priceNoDiscount() {
        double price = 0.0;
        orders.add(ArticleTest.JELLY, 7);
        price += 7 * ArticleTest.JELLY.pricingScheme().pricePerUnit();
        assertEquals(price, orders.price());
        orders.add(ArticleTest.POTATOES, 5);
        price += 5 * ArticleTest.POTATOES.pricingScheme().pricePerUnit();
        assertEquals(price, orders.price());
    }
}