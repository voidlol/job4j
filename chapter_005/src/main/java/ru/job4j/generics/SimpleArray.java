package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author - Andrey Savelov
 * @since - 20.12.2018
 */
public class SimpleArray<T> implements Iterable<T> {

    private T[] array;
    private int position = 0;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public void add(T model) {
        if (this.position >= this.array.length) {
            throw new IndexOutOfBoundsException();
        }
        this.array[this.position++] = model;
    }

    public T get(int index) {
        if (index > this.position) {
            throw new NoSuchElementException();
        }
        return this.array[index];
    }

    public void remove(int index) {
        if (index > this.position) {
            throw new NoSuchElementException();
        }
        this.array[index] = null;
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        this.position--;
    }

    public void set(int index, T model) {
        if (index > this.position) {
            throw new NoSuchElementException();
        }
        this.array[index] = model;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return position > this.index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[this.index++];
            }
        };
    }
}
