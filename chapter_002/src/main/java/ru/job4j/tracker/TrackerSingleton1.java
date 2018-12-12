package ru.job4j.tracker;

import java.util.List;

public class TrackerSingleton1 {

    private static final TrackerSingleton1 INSTANCE = new TrackerSingleton1();
    private static final Tracker TRACKER = new Tracker();

    private TrackerSingleton1() {
    }

    public static TrackerSingleton1 getINSTANCE() {
        return INSTANCE;
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
