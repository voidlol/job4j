package ru.job4j.tracker;

import java.util.List;

public class TrackerSingleton3 {
    private static TrackerSingleton3 instance;
    private static final Tracker TRACKER = new Tracker();

    private TrackerSingleton3() {

    }

    public static TrackerSingleton3 getINSTANCE() {
        if (instance == null) {
            instance = new TrackerSingleton3();
        }
        return instance;
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
