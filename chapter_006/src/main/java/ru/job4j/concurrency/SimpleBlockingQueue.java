package ru.job4j.concurrency;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 24.01.2019
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> blockingQueue = new LinkedList<>();
    private static final int CAPACITY = 10;

    public synchronized void offer(T value) throws InterruptedException {
        while (this.blockingQueue.size() >= CAPACITY) {
            wait();
        }
        blockingQueue.offer(value);
        notify();
    }

    public synchronized T poll() throws InterruptedException {
        while (this.blockingQueue.isEmpty()) {
            wait();
        }

        T value = blockingQueue.poll();
        notify();
        return value;
    }

}
