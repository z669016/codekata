package com.putoet.kata04;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Parser<T> {
    private final Function<String, T> create;

    public Parser(Function<String, T> create) {
        this.create = create;
    }

    public Optional<T> of(String line) {
        try {
            return Optional.of(create.apply(line));
        } catch (NumberFormatException | StringIndexOutOfBoundsException ignored) {}

        return Optional.empty();
    }

    public List<T> of(List<String> lines) {
        return lines.stream()
                .map(this::of)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }


    public static int asInt(String line, int start, int end) {
        return Integer.parseInt(line.substring(start, end).strip());
    }

    public static OptionalInt asOptionalInt(String line, int start, int end) {
        line = line.substring(start, end).strip();
        return line.length() > 0 ? OptionalInt.of(Integer.parseInt(line)) : OptionalInt.empty();
    }

    public static double asDouble(String line, int start, int end) {
        return Double.parseDouble(line.substring(start, end).strip());
    }

    public static String asString(String line, int start, int end) {
        return line.substring(start, end).strip();
    }
}
