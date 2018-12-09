package ru.job4j.chess.firuges;

import java.util.function.BiPredicate;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

    default Cell[] getCells(Cell source, Cell dest, int size) {
        int dx = (dest.x - source.x) / size;
        int dy = (dest.y - source.y) / size;
        Cell[] steps = new Cell[size];
        Cell tmp = source;
        for (int i = 0; i < size; i++) {
            steps[i] = Cell.values()[8 * (tmp.x + dx) + tmp.y + dy];
            tmp = steps[i];
        }
        return steps;
    }

    default boolean isCorrectMove(Cell source, Cell dest, BiPredicate<Integer, Integer> predicate) {
        int dx = Math.abs(source.x - dest.x);
        int dy = Math.abs(source.y - dest.y);
        return predicate.test(dx, dy);
    }

}
