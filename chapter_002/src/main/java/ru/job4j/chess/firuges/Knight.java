package ru.job4j.chess.firuges;

import ru.job4j.chess.ImposibleMoveException;

public abstract class Knight implements Figure {
    private final Cell position;

    public Knight(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isCorrectMove(source, dest)) {
            throw new ImposibleMoveException("Unable to move that way");
        }
        return new Cell[] {dest};
    }

    private boolean isCorrectMove(Cell source, Cell dest) {
        boolean result = false;
        int dx = Math.abs(dest.x - source.x);
        int dy = Math.abs(dest.y - source.y);
        if ((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) {
            result = true;
        }
        return result;
    }

}
