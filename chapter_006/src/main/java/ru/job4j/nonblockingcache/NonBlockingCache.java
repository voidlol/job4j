package ru.job4j.nonblockingcache;

import java.util.concurrent.ConcurrentHashMap;

public class NonBlockingCache {
    ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap();

    public boolean add(Base model) {
        boolean rst = false;
        if (!cache.containsKey(model.getId())) {
            cache.put(model.getId(), model);
            rst = true;
        }
        return rst;
    }

    public boolean update(Base model) {
        boolean rst = false;
        if (cache.containsKey(model.getId())) {
            cache.replace(model.getId(), model);
            rst = true;
        }
        return rst;
    }

    public boolean delete(Base model) {
        boolean rst = false;
        if (cache.containsKey(model.getId())) {
            cache.remove(model.getId());
            rst = true;
        }
        return rst;
    }


}
