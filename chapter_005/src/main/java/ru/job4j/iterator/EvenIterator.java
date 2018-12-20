package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {

    private final int[] values;
    private int index = 0;

    public EvenIterator(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean rst = false;
        for (int i = this.index; i < this.values.length; i++) {
            if (this.values[i] % 2 == 0) {
                this.index = i;
                rst = true;
                break;
            }
        }
        return rst;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return this.values[this.index++];
    }
}
