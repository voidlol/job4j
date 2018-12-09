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
        if (!isCorrectMove(source, dest, (dx, dy) -> (dy == 0 && dx != 0) || (dy != 0 && dx == 0) || dx == dy)) {
            throw new ImpossibleMoveException("Unable to move that way.");
        }
        int size = Math.abs(source.x - dest.x) > 0 ? Math.abs(source.x - dest.x) : Math.abs(source.y - dest.y);
        return getCells(source, dest, size);
    }

}
