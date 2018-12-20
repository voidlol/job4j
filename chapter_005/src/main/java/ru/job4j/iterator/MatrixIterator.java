package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] values;
    private int rows = 0;
    private int cells = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return this.values.length > rows + 1 || this.values[rows].length > cells + 1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.values[rows].length == cells) {
            rows++;
            cells = 0;
        }
        return this.values[rows][cells++];
    }
}
