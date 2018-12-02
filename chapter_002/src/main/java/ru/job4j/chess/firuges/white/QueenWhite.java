package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Queen;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QueenWhite extends Queen {

    public QueenWhite(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenWhite(dest);
    }
}
