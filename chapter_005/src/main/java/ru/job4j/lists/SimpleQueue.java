package ru.job4j.lists;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 22.12.2018
 */
public class SimpleQueue<T> {

    private SimpleStack<T> ss1 = new SimpleStack<>();
    private SimpleStack<T> ss2 = new SimpleStack<>();

    public T poll() {
        if (ss2.isEmpty()) {
            while(!ss1.isEmpty()) {
                ss2.push(ss1.poll());
            }
        }
        return ss2.poll();
    }

    public void push(T value) {
        ss1.push(value);
    }
}
