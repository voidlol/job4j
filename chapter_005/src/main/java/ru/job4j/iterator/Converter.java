package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            Iterator<Integer> currentIt = it.next();

            @Override
            public boolean hasNext() {
                if (!currentIt.hasNext() && it.hasNext()) {
                    currentIt = it.next();
                }
                return currentIt.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return currentIt.next();
            }
        };
    }
}
