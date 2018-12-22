package ru.job4j.generics;

import java.util.Iterator;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 21.12.2018
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    protected final SimpleArray<T> store;

    protected AbstractStore(int size) {
        this.store = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        store.add(model);
    }

    @Override
    public boolean delete(String id) {
        boolean rst = false;
        Iterator<T> it = store.iterator();
        for (int i = 0; it.hasNext(); i++) {
            if (id.equals(it.next().getId())) {
                store.remove(i);
                rst = true;
                break;
            }
        }
        return rst;
    }

    @Override
    public T findById(String id) {
        Iterator<T> it = store.iterator();
        T rst = null;
        while (it.hasNext()) {
            T tmp = it.next();
            if (id.equals(tmp.getId())) {
                rst = tmp;
                break;
            }
        }
        return rst;
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rst = false;
        Iterator<T> it = store.iterator();
        for (int i = 0; it.hasNext(); i++) {
            if (id.equals(it.next().getId())) {
                store.set(i, model);
                rst = true;
                break;
            }
        }
        return rst;
    }
}
