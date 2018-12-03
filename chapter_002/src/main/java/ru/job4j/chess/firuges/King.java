package ru.job4j.chess.firuges;

import ru.job4j.chess.ImposibleMoveException;

public abstract class King implements Figure {

    private final Cell position;

    public King(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isCorrectMove(source, dest)) {
            throw new ImposibleMoveException("Unable to move that way.");
        }
        return new Cell[] {dest};
    }

    private boolean isCorrectMove(Cell source, Cell dest) {
        boolean result = false;
        int dx = Math.abs(source.x - dest.x);
        int dy = Math.abs(source.y - dest.y);
        if ((dx == 1 && dy == 1) || (dx == 1 && dy == 0) || (dx == 0 && dy == 1)) {
            result = true;
        }
        return result;
    }
}
