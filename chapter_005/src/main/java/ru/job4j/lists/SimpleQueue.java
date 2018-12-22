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
        T rst = null;
        if (!ss1.isEmpty()) {
            rst = ss1.poll();
        }
        return rst;
    }

    public void push(T value) {
        while (!ss1.isEmpty()) {
            ss2.push(ss1.poll());
        }
        ss1.push(value);
        while (!ss2.isEmpty()) {
            ss1.push(ss2.poll());
        }
    }
}
