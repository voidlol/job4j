package ru.job4j.concurrency;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 16.01.2019
 */

@ThreadSafe
public class UserStorage {

    @GuardedBy("this")
    private final Map<Integer, User> storage = new HashMap<>();

    public synchronized boolean add(User user) {
        boolean rst = false;
        if (!storage.containsKey(user.getId())) {
            storage.put(user.getId(), user);
            rst = true;
        }
        return rst;
    }

    public synchronized boolean update(User user) {
        boolean rst = false;
        if (storage.containsKey(user.getId())) {
            storage.replace(user.getId(), user);
            rst = true;
        }
        return rst;
    }

    public synchronized boolean remove(User user) {
        boolean rst = false;
        if (storage.containsKey(user.getId())) {
            storage.remove(user.getId());
            rst = true;
        }
        return rst;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean rst = false;
        if (storage.containsKey(fromId) && storage.get(fromId).getAmount() >= amount && storage.containsKey(toId)) {
            User from = storage.get(fromId);
            User to = storage.get(toId);
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
            rst = true;
        }
        return rst;
    }

    public synchronized int getSize() {
        return this.storage.size();
    }
}
