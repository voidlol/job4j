package ru.job4j.lists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 22.12.2018
 */
public class DynamicArray<T> implements Iterable<T> {

    private static final int NEW_SIZE_MULTIPLIER = 2;
    private static final int INITIAL_SIZE = 10;
    private int index = 0;
    private int modCount = 0;
    private T[] array;

    public DynamicArray() {
        this.array = (T[]) new Object[INITIAL_SIZE];
    }

    public void add(T element) {
        this.array[this.index++] = element;
        modCount++;
        if (this.index >= this.array.length) {
            grow();
        }
    }

    public T get(int index) {
        return this.array[index];
    }

    private void grow() {
        System.arraycopy(this.array, 0, this.array, 0, this.array.length * NEW_SIZE_MULTIPLIER);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int expectedModCount = modCount;
            private int position = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return position < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[position++];
            }
        };
    }
}
