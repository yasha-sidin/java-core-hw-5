package main;

import main.Grade;

import java.util.HashMap;
import java.util.Map;

public class GradeMeanings {
    private static final Map<Grade, Integer> meanings = Map.of(
            Grade.ONE, 1,
            Grade.TWO, 2,
            Grade.THREE, 3,
            Grade.FOUR, 4,
            Grade.FIVE, 5
    );

    public static int getMeaning(Grade grade) {
        return meanings.get(grade);
    }
}
