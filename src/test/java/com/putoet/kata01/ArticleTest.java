package com.putoet.kata01;

class ArticleTest {
    public static Article JELLY = new Article("Strawberry Jelly", new NumberPricingScheme(1.95));
    public static Article MILK = new Article("Milk bottle", new NumberPricingScheme(2.13));
    public static Article POTATOES = new Article("Sweet potatoes", new WeightPricingScheme(4.25));
    public static Article CAT_FOOD = new Article("Cat food", new WeightPricingScheme(6.25));
}