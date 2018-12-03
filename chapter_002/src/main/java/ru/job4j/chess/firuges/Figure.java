package ru.job4j.chess.firuges;

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
            steps[i] = Cell.getCell(tmp.x + dx, tmp.y + dy);
            tmp = steps[i];
        }
        return steps;
    }

    default boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)) {
            result = true;
        }
        return result;
    }

    default boolean isHorizontal(Cell source, Cell dest) {
        boolean result = false;
        if (dest.y == source.y && dest.x != source.x) {
            result = true;
        }
        return result;
    }

    default boolean isVertical(Cell source, Cell dest) {
        boolean result = false;
        if (dest.y != source.y && dest.x == source.x) {
            result = true;
        }
        return result;
    }
}
