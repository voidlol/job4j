package ru.job4j.set;

import ru.job4j.lists.DynamicArray;

import java.util.Iterator;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 24.12.2018
 */
public class SimpleSet<T> implements Iterable<T> {

    private DynamicArray<T> da = new DynamicArray<>();

    public void add(T element) {
        if (!contains(element)) {
            da.add(element);
        }
    }

    private boolean contains(T element) {
        boolean rst = false;
        Iterator<T> it = da.iterator();
        while (it.hasNext()) {
            if (element.equals(it.next())) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    @Override
    public Iterator<T> iterator() {
        return da.iterator();
    }
}
