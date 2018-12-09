package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

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
        if (!isCorrectMove(source, dest, (dx, dy) -> ((dx == 1 && dy == 1) || (dx == 1 && dy == 0) || (dx == 0 && dy == 1)))) {
            throw new ImpossibleMoveException("Unable to move that way.");
        }
        return new Cell[] {dest};
    }

}
