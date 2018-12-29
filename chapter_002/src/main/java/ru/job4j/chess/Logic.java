package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int i = this.findBy(source);
        if (i == -1) {
            throw new FigureNotFoundException("Not found");
        }
        Cell[] steps = this.figures[i].way(source, dest);
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            for (Cell step : steps) {
                if (this.findBy(step) != -1) {
                    throw new OccupiedWayException("Путь занят.");
                }
            }
            rst = true;
            this.figures[i] = this.figures[i].copy(dest);
        }
        return rst;
    }

    public boolean validateMove(Cell source, Cell dest) {
        boolean rst = false;
        try {
            rst = move(source, dest);
        } catch (FigureNotFoundException fnfe) {
            System.out.println("Здесь нет фигуры!");
        } catch (ImpossibleMoveException ime) {
            System.out.println("Так ходить нельзя!");
        } catch (OccupiedWayException owe) {
            System.out.println("Путь занят.");
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        return IntStream.range(0, this.figures.length)
                .filter(i -> this.figures[i] != null && this.figures[i].position().equals(cell))
                .findFirst().orElse(-1);
    }
}
