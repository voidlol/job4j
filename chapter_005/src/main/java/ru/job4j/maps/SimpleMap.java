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

    private void transferNodes(Node<K, V> e, int newLength, Node<K, V>[] newArray) {
        while (e != null) {
            if (newArray[(newLength - 1) & e.hash] == null) {
                newArray[(newLength - 1) & e.hash] = e;
            } else {
                Node<K, V> se = newArray[(newLength - 1) & e.hash];
                while (se.next != null) {
                    se = se.next;
                }
                se.next = e;
            }
            Node<K, V> ne = e.next;
            e.next = null;
            e = ne;
        }
    }

    private void grow() {
        if (currentSize > array.length * LOAD_FACTOR) {
            int newLength = array.length << 1;
            Node<K, V>[] newArray = new Node[newLength];
            for (Node<K, V> kvNode : array) {
                if (kvNode != null) {
                    transferNodes(kvNode, newLength, newArray);
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
        } else {
            while (current != null) {
                if (current.hash == hash && current.key.equals(key)) {
                    rst = false;
                    current.value = value;
                    break;
                } else if (current.next != null) {
                    current = current.next;
                } else {
                    break;
                }
            }
            if (rst && current != null) {
                current.next = new Node<>(key, value, hash);
            }
        }
        if (rst) {
            modCount++;
            currentSize++;
            grow();
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
            int counter = 0;
            private Node<K, V> position;


            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return currentSize > counter;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (position == null) {
                    for (; index < array.length; index++) {
                        if (array[index] != null) {
                            position = array[index];
                            index++;
                            break;
                        }
                    }
                }
                Node<K, V> rst = new Node<>(position.key, position.value);
                position = position.next;
                counter++;
                return rst;
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

        public Node(K key, V value) {
            this(key, value, 0);
        }

        @Override
        public String toString() {
            return String.format("%s:%s", key, value);
        }

    }
}
