package ru.job4j.lists;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 22.12.2018
 */
public class SimpleLinkedList<T> {
    private int size;
    private Node<T> first;

    public void add(T element) {
        Node<T> newLink = new Node<>(element);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
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
        return this.first.element;
    }

    public int getSize() {
        return this.size;
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}
