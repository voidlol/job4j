package ru.job4j.lists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 22.12.2018
 */
public class SimpleLinkedList<T> implements Iterable {
    private int size;
    private Node<T> first;
    private int modCount = 0;

    public void add(T element) {
        Node<T> newLink = new Node<>(element);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    public T get(int index) {
        Node<T> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.element;
    }

    public T delete() {
        this.first = this.first.next;
        this.modCount++;
        return this.first.element;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            private Node<T> position = first;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return this.position.next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T rst = position.element;
                position = position.next;
                return rst;
            }
        };
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}
