package ru.job4j.tracker;

import java.util.List;

public class TrackerSingleton4 {
    private static final Tracker TRACKER = new Tracker();

    private static final class Holder {
        private static final TrackerSingleton4 INSTANCE = new TrackerSingleton4();
    }

    private TrackerSingleton4() {

    }

    public static TrackerSingleton4 getINSTANCE() {
        return Holder.INSTANCE;
    }

    public Item add(Item item) {
        return TRACKER.add(item);
    }

    public boolean replace(String id, Item item) {
        return TRACKER.replace(id, item);
    }

    public boolean delete(String id) {
        return TRACKER.delete(id);
    }

    public List<Item> findAll() {
        return TRACKER.findAll();
    }

    public Item findById(String id) {
        return TRACKER.findById(id);
    }

    public List<Item> findByName(String name) {
        return TRACKER.findByName(name);
    }
}
