package com.putoet.kata04;

import com.putoet.resources.ResourceLines;
import org.javatuples.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DataMunging {
    public static void main(String[] args) {
        weatherData(getWeatherStats());
        footballData(getFootballStats());
    }

    private static List<WeatherStats> getWeatherStats() {
        final List<String> lines = ResourceLines.list("/weather.dat");
        return new Parser<>(WeatherStats::create).of(lines);
    }

    private static void weatherData(List<WeatherStats> stats) {
        final Optional<Pair<Integer, Integer>> day = stats.stream()
                .map(stat -> new Pair<>(Math.abs(stat.mxt - stat.mnt), stat.dy))
                .min(Comparator.comparing(Pair::getValue0));

        if (day.isEmpty())
            System.out.println("No stats on any day...");
        else
            System.out.println("Day with the smallest temerature spread is " + day.get().getValue1());
    }

    private static List<FootallStats> getFootballStats() {
        final List<String> lines = ResourceLines.list("/football.dat");
        return new Parser<>(FootallStats::create).of(lines);
    }

    private static void footballData(List<FootallStats> stats) {
        final Optional<Pair<Integer, String>> day = stats.stream()
                .map(stat -> new Pair<>(Math.abs(stat.goalsFor - stat.goalsAGainst), stat.team))
                .min(Comparator.comparing(Pair::getValue0));

        if (day.isEmpty())
            System.out.println("No stats on football...");
        else
            System.out.println("Team with the least difference between goals for anf goals against is  " + day.get().getValue1());
    }
}
