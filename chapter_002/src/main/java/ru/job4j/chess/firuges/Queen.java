package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class Queen implements Figure {
    private final Cell position;

    protected Queen(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!(isDiagonal(source, dest) || isHorizontal(source, dest) || isVertical(source, dest))) {
            throw new ImpossibleMoveException("Unable to move that way.");
        }
        int size = isHorizontal(source, dest) ? Math.abs(source.x - dest.x) : Math.abs(source.y - dest.y);
        return getCells(source, dest, size);
    }

}
