package ru.job4j.maps;

import java.util.*;

/**
 * @author - Andrey Savelov
 * @version - 1.1
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
        int h = o.hashCode();
        return (h ^ (h >>> 16) & h);
    }

    private void grow() {
        if (++currentSize == array.length * LOAD_FACTOR) {
            int newLength = array.length << 1;
            Node<K, V>[] newArray = new Node[newLength];
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    newArray[(newLength - 1) & array[i].hash] = array[i];
                }
            }
            array = newArray;
        }
    }

    public boolean insert(K key, V value) {
        boolean rst = true;
        int hash = hash(key);
        Node current = array[(array.length - 1) & hash];
        if (array[(array.length - 1) & hash] == null) {
            array[(array.length - 1) & hash] = new Node<>(key, value, hash);
            modCount++;
            grow();
        } else {
            while (current != null) {
                if (current.hash == hash && current.key.equals(key)) {
                    rst = false;
                    break;
                } else if (current.next != null){
                    current = current.next;
                } else {
                    break;
                }
            }
            if (rst) {
                current.next = new Node(key, value, hash);
            }
        }

        return rst;
    }

    public V get(K key) {
        int hash = hash(key);
        V rst = null;
        Node<K, V> current = array[(array.length - 1) & hash];
        while (current != null) {
            if (current.hash == hash && current.key.equals(key)) {
                rst = current.value;
                break;
            } else {
                current = current.next;
            }
        }
        return rst;
    }

    public boolean delete(K key) {
        boolean rst = false;
        int hash = hash(key);
        Node<K, V> current = array[(array.length - 1) & hash];
        Node<K, V> prev = array[(array.length - 1) & hash];
        while (current != null) {
            if (current.hash == hash && current.key.equals(key)) {
                if (current.next == null) {
                    prev.next = null;
                } else {
                    prev.next = current.next;
                }
                rst = true;
                modCount++;
                break;
            } else {
                prev = current;
                current = current.next;
            }

        }

        return rst;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int index = 0;
            private Node<K, V> position;
            private Node<K, V> nextPos = array[index];

            private void getPos() {
                position = nextPos;
                while (position == null) {
                    position = array[++index];
                }
                nextPos = position.next;
            }

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean rst = false;
                if (index < array.length) {
                    if (nextPos != null) {
                        rst = true;
                    } else {
                        for (int i = index + 1; i < array.length; i++) {
                            if (array[i] != null) {
                                rst = true;
                                break;
                            }
                        }
                    }
                } else if (nextPos != null) {
                    rst = true;
                }

                return rst;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                getPos();
                return position;
            }
        };
    }

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next = null;
        private int hash;

        public Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        @Override
        public String toString() {
            return String.format("Key = %s%nValue = %s", key, value);
        }

    }
}
