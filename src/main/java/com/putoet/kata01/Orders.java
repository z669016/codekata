package com.putoet.kata01;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Pair<Article, Integer>> orderLines = new ArrayList<>();

    public List<Pair<Article, Integer>> orderLines() {
        return orderLines;
    }

    public double price() {
        return orderLines.stream().mapToDouble(order -> order.getValue0().pricingScheme().price(order.getValue1())).sum();
    }

    public Orders add(Article article, int units) {
        assert article != null;
        assert units > 0;

        final int idx = find(article);
        if (idx == -1)
            orderLines.add(Pair.with(article, units));
        else {
            final Pair<Article, Integer> orderLine = orderLines.get(idx);
            orderLines.set(idx, Pair.with(orderLine.getValue0(), orderLine.getValue1() + units));
        }

        return this;
    }

    public Orders remove(Article article, int units) {
        assert article != null;
        assert units > 0;

        final int idx = find(article);
        if (idx != -1) {
            final Pair<Article, Integer> orderLine = orderLines.get(idx);
            if (units == orderLine.getValue1())
                orderLines.remove(idx);
            else if (units < orderLine.getValue1())
                orderLines.set(idx, Pair.with(orderLine.getValue0(), orderLine.getValue1() - units));
            else
                throw new IllegalArgumentException("Cannot remove " + units + " of " + article.description() + " from ordered " + orderLine.getValue1());
        }
        return this;
    }

    private int find(Article article) {
        assert article != null;

        for (int idx = 0; idx < orderLines.size(); idx++) {
            if (orderLines.get(idx).getValue0().equals(article))
                return idx;
        }

        return -1;
    }
}
