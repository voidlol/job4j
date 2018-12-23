package ru.job4j.lists;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 22.12.2018
 */
public class SimpleStack<T> {
    private SimpleLinkedList<T> sll = new SimpleLinkedList<>();
    int size = 0;

    public T poll() {
        size--;
        return sll.delete();
    }

    public void push(T element) {
        sll.add(element);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
