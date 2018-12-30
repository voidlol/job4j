package ru.job4j.trees;

import java.util.Optional;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 29.12.2018
 */
public interface SimpleTree<T extends Comparable<T>> extends Iterable<T> {

    boolean add(T parent, T child);

    Optional<Node<T>> findBy(T value);
}
