package ru.job4j.maps;

import java.util.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 26.12.2018
 */
public class SimpleMap<K, V> implements Iterable<SimpleMap.Node<K, V>> {

    private Node<K, V>[] array;
    private static final int INIT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int modCount = 0;
    private int currentSize = 0;

    public SimpleMap() {
        this.array = new Node[INIT_CAPACITY];
    }

    private int hash(K o) {
        int h = 31 * 17 + o.hashCode();
        return h & (array.length - 1);
    }

    private void grow() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    public boolean insert(K key, V value) {
        boolean rst = false;
        int hash = hash(key);
        if (array[hash] == null) {
            rst = true;
            array[hash] = new Node<>(key, value);
            modCount++;
            if (++currentSize == array.length * LOAD_FACTOR) {
                grow();
            }
        }

        return rst;
    }

    public V get(K key) {
        int hash = hash(key);
        return array[hash] != null  && array[hash].key == key ? array[hash].value : null;
    }

    public boolean delete(K key) {
        boolean rst = false;
        int hash = hash(key);
        if (array[hash] != null) {
            rst = true;
            array[hash] = null;
            currentSize--;
            modCount++;
        }
        return rst;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean rst = false;
                for (; index < array.length - 1; index++) {
                    if (array[index] != null) {
                        return true;
                    }
                }
                return rst;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        };
    }

    static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("Key = %s%nValue = %s", key, value);
        }
    }
}
