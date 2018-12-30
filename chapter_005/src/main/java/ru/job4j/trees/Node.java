package ru.job4j.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 29.12.2018
 */
public class Node<T extends Comparable<T>> {
    private final List<Node<T>> children = new ArrayList<>();
    private final T value;

    public Node(final T value) {
        this.value = value;
    }

    public void add(Node<T> child) {
        this.children.add(child);
    }

    public List<Node<T>> leaves() {
        return this.children;
    }

    public T getValue() {
        return this.value;
    }

    public boolean eqValue(T that) {
        return this.value.compareTo(that) == 0;
    }
}

