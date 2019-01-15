package ru.job4j.concurrency;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.lists.DynamicArray;

import java.util.Iterator;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 16.01.2019
 */
@ThreadSafe
public class ConcurrencyWrapper<T> extends DynamicArray<T> {

    @GuardedBy("this")
    private DynamicArray<T> da = new DynamicArray<>();

    @Override
    public synchronized void add(T element) {
        this.da.add(element);
    }

    @Override
    public synchronized T get(int index) {
        return this.da.get(index);
    }

    @Override
    public synchronized int size() {
        return this.da.size();
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.da).iterator();
    }

    private DynamicArray<T> copy(DynamicArray<T> da) {
        DynamicArray<T> snapshot = new DynamicArray<>();
        for (T value : da) {
            snapshot.add(value);
        }
        return snapshot;
    }
}
