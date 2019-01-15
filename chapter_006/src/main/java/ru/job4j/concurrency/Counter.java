package ru.job4j.concurrency;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 15.01.2019
 */

@ThreadSafe
public class Counter {

    @GuardedBy("this")
    private long count = 0;

    public synchronized void increment() {
        this.count++;
    }

    public synchronized long getCount() {
        return this.count;
    }
}
