package com.putoet.kata01;

public class Article implements Comparable<Article> {
    private final String description;
    private PricingScheme pricing;

    public Article(String description, PricingScheme pricing) {
        this.description = description;
        this.pricing = pricing;
    }

    public String description() { return description; }
    public PricingScheme pricingScheme() { return pricing; }
    public Article pricingScheme(PricingScheme pricingScheme) {
        this.pricing = pricingScheme;
        return this;
    }

    @Override
    public String toString() { return description; }

    @Override
    public int compareTo(Article other) {
        assert other != null;
        return description.compareTo(other.description);
    }
}
